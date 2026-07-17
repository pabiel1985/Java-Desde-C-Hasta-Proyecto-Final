@echo off
title Crear Proyecto Java
color 0A

echo.
echo ==========================================
echo      CREANDO PROYECTO JAVA
echo ==========================================
echo.

for /f "tokens=1,2 delims=|" %%a in (estructura.txt) do (

    REM ======================================
    REM Crear modulo y tema
    REM ======================================

    mkdir "%%a" 2>nul
    mkdir "%%a\%%b" 2>nul

    REM ======================================
    REM Eliminar carpetas antiguas
    REM ======================================

    if exist "%%a\%%b\apuntes" (
        rmdir /s /q "%%a\%%b\apuntes"
    )

    if exist "%%a\%%b\practicas" (
        rmdir /s /q "%%a\%%b\practicas"
    )

    REM ======================================
    REM Crear README
    REM ======================================

    if not exist "%%a\%%b\README.md" (

        (
            echo # %%b
            echo.
            echo ## Objetivos
            echo.
            echo.
            echo ## Explicacion
            echo.
            echo.
            echo ## Comparacion con C
            echo.
            echo.
            echo ## Ejemplos
            echo.
            echo.
            echo ## Ejercicio guiado
            echo.
            echo.
            echo ## Ejercicio para resolver solo
            echo.
            echo.
            echo ## Buenas practicas
            echo.
            echo.
            echo ## Errores comunes
            echo.
            echo.
            echo ## Mini desafio
            echo.
        ) > "%%a\%%b\README.md"

    )

    REM ======================================
    REM Crear carpetas
    REM ======================================

    for %%d in (ejemplos ejercicios recursos) do (

        mkdir "%%a\%%b\%%d" 2>nul

        if not exist "%%a\%%b\%%d\.gitkeep" (
            type nul > "%%a\%%b\%%d\.gitkeep"
        )

    )

)

echo.
echo ==========================================
echo      PROYECTO ACTUALIZADO
echo ==========================================
echo.

pause