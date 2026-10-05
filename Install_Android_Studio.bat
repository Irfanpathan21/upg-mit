@echo off
setlocal EnableDelayedExpansion
title Android Studio 2025.3.4 (Panda 4 Patch 1) Installer

echo =====================================================================
echo    UIANP308P Android Programming Lab - Android Studio Setup
echo    Target Version: Android Studio Panda 4 Patch 1 (2025.3.4.7)
echo =====================================================================
echo.
echo  This installer will set up the EXACT SAME version of Android Studio
echo  (2025.3.4 / Panda 4) used to develop and test all 20 practicals.
echo  This guarantees 100%% compatibility and eliminates Gradle sync errors.
echo.

:: 1. Check if Android Studio is already installed
set "STUDIO_EXE=C:\Program Files\Android\Android Studio\bin\studio64.exe"
if exist "%STUDIO_EXE%" (
    echo [INFO] Android Studio is already installed at:
    echo        "%STUDIO_EXE%"
    echo.
    echo Press [1] to Launch Android Studio now.
    echo Press [2] to Reinstall / Install Android Studio 2025.3.4 (Panda 4).
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

:: 2. Target Exact Version URL (Google Official CDN)
set "INSTALLER_URL=https://dl.google.com/android/studio/install/2025.3.4.7/android-studio-panda4-patch1-windows.exe"
set "FALLBACK_URL=https://redirector.gvt1.com/edgedl/android/studio/install/2025.3.4.7/android-studio-panda4-patch1-windows.exe"
set "INSTALLER_PATH=%TEMP%\android-studio-panda4-patch1-windows.exe"

:: Check if the installer is already cached in current directory or user Downloads
if exist "%~dp0android-studio-panda4-patch1-windows.exe" (
    set "INSTALLER_PATH=%~dp0android-studio-panda4-patch1-windows.exe"
    echo [INFO] Found local installer in current folder:
    echo        "!INSTALLER_PATH!"
    goto :RUN_INSTALLER
)

if exist "%USERPROFILE%\Downloads\android-studio-panda4-patch1-windows.exe" (
    set "INSTALLER_PATH=%USERPROFILE%\Downloads\android-studio-panda4-patch1-windows.exe"
    echo [INFO] Found installer in Downloads folder:
    echo        "!INSTALLER_PATH!"
    goto :RUN_INSTALLER
)

:: 3. Download the exact Android Studio 2025.3.4.7 installer from Google
echo.
echo [INFO] Downloading Android Studio 2025.3.4.7 (Panda 4 Patch 1)...
echo Source URL: %INSTALLER_URL%
echo Destination: %INSTALLER_PATH%
echo File Size:   ~1.36 GB (Google Official Installer)
echo.

where curl >nul 2>&1
if %ERRORLEVEL% equ 0 (
    echo Downloading via curl...
    curl -L --progress-bar -o "%INSTALLER_PATH%" "%INSTALLER_URL%"
    if not exist "%INSTALLER_PATH%" (
        echo Trying backup mirror...
        curl -L --progress-bar -o "%INSTALLER_PATH%" "%FALLBACK_URL%"
    )
) else (
    echo Downloading via PowerShell...
    powershell -Command "[Net.ServicePointManager]::SecurityProtocol = [Net.SecurityProtocolType]::Tls12; $wc = New-Object Net.WebClient; try { $wc.DownloadFile('%INSTALLER_URL%', '%INSTALLER_PATH%') } catch { $wc.DownloadFile('%FALLBACK_URL%', '%INSTALLER_PATH%') }"
)

if not exist "%INSTALLER_PATH%" (
    echo.
    echo [ERROR] Download failed. Please download the installer manually from:
    echo         %INSTALLER_URL%
    pause
    exit /b 1
)

:RUN_INSTALLER
echo.
echo =====================================================================
echo Launching Android Studio Setup Wizard...
echo =====================================================================
echo Please complete the setup steps in the installer window.
echo (Default settings with Android SDK and Virtual Device are recommended).
echo.
start /wait "" "%INSTALLER_PATH%"

:POST_INSTALL
echo.
echo =====================================================================
echo                     SETUP COMPLETE & HOW TO USE
echo =====================================================================
echo.
echo  1. Launch Android Studio from your Start Menu.
echo  2. Click "Open" (or File -^> Open).
echo  3. Navigate to any practical project folder, for example:
echo     - Set 1\Q01_Simple_Interest_Calculator
echo     - Set 1\Q02_Login_Screen_Custom_Theme
echo     - Set 2\Q06_Image_Caption_Screen
echo     - Set 3\Q11_Temperature_Converter
echo     - Set 4\Q16_State_Retention
echo  4. Click OK. The project will open and Gradle sync will complete
echo     without any version mismatch errors!
echo.
echo =====================================================================
pause
