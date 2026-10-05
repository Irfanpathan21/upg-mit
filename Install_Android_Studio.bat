@echo off
setlocal EnableDelayedExpansion
title Android Studio Setup - UIANP308P Practicals

echo =====================================================================
echo    UIANP308P Android Programming Lab - Android Studio Installer
echo =====================================================================
echo.
echo  This tool will check, download, and install the compatible version
echo  of Android Studio so that all 20 Kotlin practicals sync and run
echo  with 100%% compatibility on this computer.
echo.

:: 1. Check if Android Studio is already installed
set "STUDIO_EXE=C:\Program Files\Android\Android Studio\bin\studio64.exe"
if exist "%STUDIO_EXE%" (
    echo [INFO] Android Studio is already installed at:
    echo        "%STUDIO_EXE%"
    echo.
    echo Press [1] to Launch Android Studio now.
    echo Press [2] to Reinstall / Update Android Studio.
    echo Press [3] to Exit.
    echo.
    set /p "CHOICE=Enter your choice (1, 2, or 3): "
    if "!CHOICE!"=="1" (
        start "" "%STUDIO_EXE%"
        exit /b 0
    )
    if "!CHOICE!"=="3" (
        exit /b 0
    )
)

:: 2. Try installation via Windows Package Manager (winget)
echo.
echo [STEP 1/2] Checking Windows Package Manager (winget)...
where winget >nul 2>&1
if %ERRORLEVEL% equ 0 (
    echo [INFO] winget detected! Attempting automatic installation...
    echo Running: winget install --id Google.AndroidStudio -e --accept-package-agreements --accept-source-agreements
    echo.
    winget install --id Google.AndroidStudio -e --accept-package-agreements --accept-source-agreements
    if %ERRORLEVEL% equ 0 (
        echo.
        echo =====================================================================
        echo [SUCCESS] Android Studio installed successfully via winget!
        echo =====================================================================
        goto :POST_INSTALL
    ) else (
        echo [WARN] winget install returned non-zero code. Falling back to direct download...
    )
) else (
    echo [INFO] winget is not available on this system. Falling back to direct download...
)

:: 3. Direct Official Download from Google CDN
echo.
echo [STEP 2/2] Downloading official Android Studio installer directly from Google CDN...
set "INSTALLER_URL=https://edgedl.me.gvt1.com/android/studio/install/2026.2.1.8/android-studio-rabbit1-windows.exe"
set "INSTALLER_PATH=%TEMP%\android-studio-installer.exe"

echo Target URL: %INSTALLER_URL%
echo Saving to:   %INSTALLER_PATH%
echo.

where curl >nul 2>&1
if %ERRORLEVEL% equ 0 (
    echo Using curl to download installer (please wait, ~1.4 GB)...
    curl -L --progress-bar -o "%INSTALLER_PATH%" "%INSTALLER_URL%"
) else (
    echo Using PowerShell to download installer (please wait, ~1.4 GB)...
    powershell -Command "[Net.ServicePointManager]::SecurityProtocol = [Net.SecurityProtocolType]::Tls12; (New-Object Net.WebClient).DownloadFile('%INSTALLER_URL%', '%INSTALLER_PATH%')"
)

if not exist "%INSTALLER_PATH%" (
    echo.
    echo [ERROR] Download failed. Please download Android Studio manually from:
    echo         https://developer.android.com/studio
    pause
    exit /b 1
)

echo.
echo [INFO] Download complete! Launching Android Studio Setup Wizard...
echo Please follow the prompts in the installer window to complete the setup.
echo.
start /wait "" "%INSTALLER_PATH%"

:POST_INSTALL
echo.
echo =====================================================================
echo                    SETUP COMPLETE & HOW TO USE
echo =====================================================================
echo.
echo  1. Launch Android Studio from the Start Menu or desktop shortcut.
echo  2. Click "Open" (or File -^> Open).
echo  3. Navigate into any project folder, for example:
echo     - Set 1\Q01_Simple_Interest_Calculator
echo     - Set 1\Q02_Login_Screen_Custom_Theme
echo     - Set 2\Q06_Image_Caption_Screen
echo     - Set 3\Q11_Temperature_Converter
echo     - Set 4\Q16_State_Retention
echo  4. Click OK. Android Studio will automatically perform Gradle sync
echo     and open the project ready to build and run!
echo.
echo =====================================================================
pause
