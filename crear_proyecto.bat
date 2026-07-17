@echo off
title Crear Proyecto Java
color 0A

echo.
echo ==========================================
echo    CREANDO ESTRUCTURA DEL PROYECTO JAVA
echo ==========================================
echo.

for /f "tokens=1,2 delims=|" %%a in (estructura.txt) do (

    REM Crear modulo
    mkdir "%%a" 2>nul

    REM Crear tema
    mkdir "%%a\%%b" 2>nul

    REM Crear README.md
    if not exist "%%a\%%b\README.md" (
        (
            echo # %%b
            echo.
            echo ## Objetivos
            echo.
            echo ## Teoria
            echo.
            echo ## Ejemplos
            echo.
            echo ## Ejercicios
            echo.
            echo ## Observaciones
        )>"%%a\%%b\README.md"
    )

    REM Crear subcarpetas
    for %%d in (apuntes ejemplos ejercicios practicas recursos) do (

        mkdir "%%a\%%b\%%d" 2>nul

        REM Crear .gitkeep
        if not exist "%%a\%%b\%%d\.gitkeep" (
            type nul > "%%a\%%b\%%d\.gitkeep"
        )
    )
)

echo.
echo ==========================================
echo        PROYECTO CREADO CORRECTAMENTE
echo ==========================================
echo.

pause