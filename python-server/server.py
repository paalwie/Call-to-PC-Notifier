from http.server import BaseHTTPRequestHandler, HTTPServer

class CallHandler(BaseHTTPRequestHandler):
    def do_POST(self):
        if self.path == "/call":
            length = int(self.headers.get("Content-Length", 0))
            data = self.rfile.read(length).decode()

            print("\n 📞 Eingehender Anruf!")
            if data:
                print("Daten: ", data)

            self.send_response(200)
            self.end_headers()

    def log_message(self, format, *args):
        pass

if __name__ == "__main__":
    server = HTTPServer(("0.0.0.0", 5000), CallHandler)
    print("Warte auf Anrufe auf Port 5000...")
    server.serve_forever()
