# DailyCrispMeBackend

## Running the Application Locally

1. **Start the Spring Boot backend:**
   Run the application from your IDE or via Maven/Gradle. By default, it runs on `http://localhost:8080`.

2. **Start the Cloudflare Tunnel:**
   The backend is exposed to the internet via Cloudflare Tunnel (`api.dailycrisp.me`). You must start this tunnel locally to route traffic to your running Spring Boot app.
   
   Run the following command in a new terminal window to **start** the tunnel:
   ```bash
   cloudflared tunnel run --token eyJhIjoiYjE1MjI1ODExYjhiZmQ3MGE5MTIyYmQzZDdhYzI3Y2UiLCJ0IjoiZTNkNWEyMDMtMGY0Ny00ZDk1LWEwODctNDQwOGZjMGJmOGEyIiwicyI6Ik9EQTBZamhrTW1VdFlqa3haeTAwTTJSa0xXSTBOemN0TkRZek56STVNMkV3WWpndyJ9
   ```

3. **Stop the Cloudflare Tunnel:**
   To stop tunneling traffic to your application, you can simply press `Ctrl + C` in the terminal window where the `cloudflared` command is running.