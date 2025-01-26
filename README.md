# Instrukcja obsługi aplikacji OCRaider

## Wprowadzenie
Aplikacja OCRaider to narzędzie do konwersji dokumentów w formacie PNG na czytelny tekst. Wykorzystuje algorytmy rozpoznawania tekstu (OCR) do przetwarzania obrazów.

## Jak uruchomić aplikację

1. **Klonowanie repozytorium**: Użyj poniższego polecenia, aby sklonować repozytorium na swój lokalny komputer:
    ```bash
    git clone https://github.com/kazikd11/OCR
    ```

2. **Instalacja zależności**: Przejdź do katalogu frontend i backend, a następnie zainstaluj wszystkie zależności:
    ```bash
    cd OCRaider/client
    npm install
    cd ../server
    pip install -r requirements.txt
    ```

3. **Uruchamianie serwerów**: Uruchom serwery frontendowy i backendowy w osobnych terminalach:
    - Dla frontendu:
    ```bash
    cd OCRaider/client
    npm run dev
    ```

    - Dla backendu:
    ```bash
    cd OCRaider/server
    python manage.py runserver
    ```

## Jak korzystać z aplikacji
1. Otwórz przeglądarkę i przejdź do adresu `http://localhost:5173` (lub innego portu, jeśli zmieniłeś konfigurację).
2. Użyj interfejsu użytkownika, aby przesłać plik PNG do przetworzenia.
3. Po przetworzeniu pliku, wynikowy tekst zostanie wyświetlony na ekranie, skąd możesz go skopiować.

