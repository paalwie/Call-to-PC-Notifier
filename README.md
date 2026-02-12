# 📞 Call-to-PC Notifier 
> **Aktuelle Version:** v1.1 (Sound & UI Update)

Ein einfaches Tool-Duo, um eingehende Anrufe von einem Android-Smartphone (z. B. Samsung A35) direkt auf dem PC-Monitor anzuzeigen.

## 🚀 Funktionen
- **Echtzeit-Benachrichtigung:** Sobald das Handy klingelt, erscheint die Info im PC-Terminal.
- **Nummer-Anzeige:** Übermittelt die Telefonnummer des Anrufers.
- **Flexible IP:** Die PC-Adresse kann direkt in der App geändert werden (kein Hardcoding nötig).
- **Akustisches Signal:** Der PC spielt bei Anruf eine Sirene/Tonfolge ab.

## 🛠 Setup

### 1. PC (Python Server)
- Installiere Python (falls nicht vorhanden).
- Starte den Server mit: `python server.py` (Die Endung .pyw unterdrückt das Konsolenfenster).
- Der Server lauscht auf Port `5000`.

### 2. Smartphone (Android App)
- Lade die neueste `.apk` aus den [Releases](../../releases) herunter.
- Gib die aktuelle IP deines PCs in der App ein.
- **Wichtig (Samsung/Android 16):** - Erlaube die Berechtigungen `READ_PHONE_STATE` und `READ_CALL_LOG`.
    - Deaktiviere die Akku-Optimierung für die App ("Nicht eingeschränkt"), damit sie im Hintergrund aktiv bleibt.

## 📂 Struktur
- `/android-app`: Das vollständige Android Studio Projekt (Kotlin).
- `/python-server`: Das Python-Skript für die PC-Seite.

---

## 📝 Updates

### v1.1 - Sound/UI-Update
- **Neue UI:** Die Android-App wurde optisch überarbeitet, zentriert und zeigt nun die aktuell gespeicherte IP-Adresse dauerhaft an.
- **Sound-Alarm:** Der Python-Server nutzt nun `winsound`, um bei einem Anruf einen Sound abzuspielen.
- **Bugfixes:** Stabilerer Verbindungsaufbau und verbesserte Berechtigungsabfrage für Android 16.
