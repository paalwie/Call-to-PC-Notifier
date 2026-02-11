# 📞 Call-to-PC Notifier

Ein einfaches Tool-Duo, um eingehende Anrufe von einem Android-Smartphone (z. B. Samsung A35) direkt auf dem PC-Monitor anzuzeigen.

## 🚀 Funktionen
- **Echtzeit-Benachrichtigung:** Sobald das Handy klingelt, erscheint die Info im PC-Terminal.
- **Nummer-Anzeige:** Übermittelt die Telefonnummer des Anrufers.
- **Flexible IP:** Die PC-Adresse kann direkt in der App geändert werden (kein Hardcoding nötig).

## 🛠 Setup

### 1. PC (Python Server)
- Installiere Python (falls nicht vorhanden).
- Starte den Server mit: `python server.py`
- Der Server lauscht auf Port `5000`.

### 2. Smartphone (Android App)
- Lade die `.apk` aus den [Releases](../../releases) herunter und installiere sie.
- Gib die aktuelle IP deines PCs in der App ein.
- **Wichtig (Samsung/Android 16):** - Erlaube die Berechtigungen `READ_PHONE_STATE` und `READ_CALL_LOG`.
    - Deaktiviere die Akku-Optimierung für die App ("Nicht eingeschränkt"), damit sie im Hintergrund aktiv bleibt.

## 📂 Struktur
- `/android-app`: Das vollständige Android Studio Projekt (Kotlin).
- `/python-server`: Das Python-Skript für die PC-Seite.
