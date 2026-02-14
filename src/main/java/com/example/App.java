package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Map;

@SpringBootApplication
@RestController
public class App {

    // HOME PAGE
    @GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
    public String home() {
        return """
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>Kastro DevOps Bootcamp</title>

  <style>
    :root{
      --bg1:#070A12;
      --bg2:#0B1224;
      --card: rgba(255,255,255,0.06);
      --border: rgba(255,255,255,0.10);
      --text:#EAF2FF;
      --muted: rgba(234,242,255,0.70);
      --primary:#00F5D4;
      --secondary:#FFB703;
      --blue:#3A86FF;
    }

    *{margin:0;padding:0;box-sizing:border-box;}

    body{
      font-family: system-ui, -apple-system, Segoe UI, Roboto, Arial, sans-serif;
      color: var(--text);
      background: radial-gradient(circle at 20% 10%, rgba(58,134,255,0.18), transparent 40%),
                  radial-gradient(circle at 80% 60%, rgba(0,245,212,0.12), transparent 45%),
                  linear-gradient(180deg, var(--bg1), var(--bg2));
      min-height:100vh;
      overflow-x:hidden;
    }

    header{
      max-width:1200px;
      margin:0 auto;
      padding:28px 20px;
      display:flex;
      align-items:center;
      justify-content:space-between;
    }

    .brand{
      display:flex;
      align-items:center;
      gap:12px;
      font-weight:800;
      letter-spacing:0.5px;
      font-size:1.1rem;
    }

    .logo{
      width:42px;height:42px;border-radius:14px;
      background: linear-gradient(135deg, var(--primary), var(--blue));
      box-shadow: 0 0 40px rgba(0,245,212,0.25);
    }

    nav a{
      color:var(--muted);
      text-decoration:none;
      margin-left:18px;
      font-weight:600;
      transition:0.25s;
    }
    nav a:hover{color:var(--primary);}

    .hero{
      max-width:1200px;
      margin:0 auto;
      padding:40px 20px 10px;
      display:grid;
      grid-template-columns: 1.1fr 0.9fr;
      gap:30px;
      align-items:center;
    }

    .badge{
      display:inline-flex;
      gap:10px;
      align-items:center;
      padding:10px 16px;
      border:1px solid rgba(0,245,212,0.25);
      background: rgba(0,245,212,0.06);
      border-radius:999px;
      color: var(--primary);
      font-weight:700;
      letter-spacing:1px;
      font-size:0.95rem;
    }

    h1{
      margin-top:18px;
      font-size:3.2rem;
      line-height:1.05;
      font-weight:900;
      background: linear-gradient(90deg, var(--primary), var(--blue), var(--secondary));
      -webkit-background-clip:text;
      background-clip:text;
      color:transparent;
    }

    .subtitle{
      margin-top:18px;
      color: var(--muted);
      font-size:1.25rem;
      line-height:1.7;
      max-width:620px;
    }

    .cta-row{
      display:flex;
      gap:16px;
      flex-wrap:wrap;
      margin-top:28px;
    }

    .btn{
      padding:16px 22px;
      border-radius:18px;
      font-weight:800;
      text-decoration:none;
      border:1px solid var(--border);
      transition:0.25s;
      display:inline-flex;
      align-items:center;
      gap:10px;
    }

    .btn-primary{
      background: linear-gradient(135deg, var(--secondary), #ff7b00);
      color:#101010;
      box-shadow: 0 20px 50px rgba(255,183,3,0.25);
      border:none;
    }
    .btn-primary:hover{transform:translateY(-3px);}

    .btn-ghost{
      background: rgba(255,255,255,0.04);
      color: var(--text);
    }
    .btn-ghost:hover{
      border-color: rgba(0,245,212,0.25);
      transform:translateY(-3px);
    }

    .card{
      background: var(--card);
      border:1px solid var(--border);
      border-radius:24px;
      padding:26px;
      backdrop-filter: blur(14px);
      box-shadow: 0 30px 80px rgba(0,0,0,0.45);
    }

    .right-card h3{
      font-size:1.4rem;
      margin-bottom:12px;
      color: var(--primary);
    }

    .right-card p{
      color:var(--muted);
      line-height:1.7;
      font-size:1.05rem;
    }

    .info-grid{
      max-width:1200px;
      margin:0 auto;
      padding:30px 20px 80px;
      display:grid;
      grid-template-columns: repeat(3, 1fr);
      gap:18px;
    }

    .mini h4{font-size:1.1rem;margin-bottom:8px;}
    .mini p{color:var(--muted);line-height:1.6;}

    footer{
      max-width:1200px;
      margin:0 auto;
      padding:30px 20px 60px;
      color: rgba(234,242,255,0.55);
      border-top:1px solid rgba(255,255,255,0.08);
    }

    @media(max-width: 980px){
      .hero{grid-template-columns:1fr;}
      h1{font-size:2.6rem;}
      .info-grid{grid-template-columns:1fr;}
    }
  </style>
</head>

<body>

<header>
  <div class="brand">
    <div class="logo"></div>
    <span>Kastro DevOps Bootcamp</span>
  </div>

  <nav>
    <a href="/">Home</a>
    <a href="/about">About</a>
    <a href="/health">Health</a>
  </nav>
</header>

<section class="hero">
  <div>
    <div class="badge">🚀 New Batch Starts: 29 Jan 2026</div>
    <h1>GitHub Actions + Kubernetes</h1>
    <p class="subtitle">
      Learn how real companies build CI/CD pipelines, build Docker images, push to registries,
      and deploy to Kubernetes like a production DevOps engineer.
    </p>

    <div class="cta-row">
      <a class="btn btn-primary" target="_blank"
         href="https://forms.gle/D5dib9DFsfSN4Koy7">🔥 Reserve Seat</a>

      <a class="btn btn-ghost" href="/api/info">📦 View API Info</a>
    </div>
  </div>

  <div class="card right-card">
    <h3>What you’ll build</h3>
    <p>
      ✅ GitHub Actions pipelines<br/>
      ✅ Docker build & push automation<br/>
      ✅ EC2 deployment via SSH<br/>
      ✅ Kubernetes manifests (Pod/Deployment/Service)<br/>
      ✅ EKS + Ingress + Helm + GitOps
    </p>
  </div>
</section>

<section class="info-grid">
  <div class="card mini">
    <h4>📅 Duration</h4>
    <p>35–40 days live sessions + recordings.</p>
  </div>

  <div class="card mini">
    <h4>🛠 Tools</h4>
    <p>GitHub Actions, Docker, Kubernetes, Helm, AWS EKS, ArgoCD.</p>
  </div>

  <div class="card mini">
    <h4>🏆 Projects</h4>
    <p>5 mini + 2 capstone projects with end-to-end deployments.</p>
  </div>
</section>

<footer>
  © 2026 Learn With Kastro •
  <a style="color:rgba(0,245,212,0.9)" href="mailto:learnwithkastro@gmail.com">learnwithkastro@gmail.com</a>
</footer>

</body>
</html>
        """;
    }

    // ABOUT PAGE
    @GetMapping(value = "/about", produces = MediaType.TEXT_HTML_VALUE)
    public String about() {
        return """
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8"/>
  <title>About - Kastro</title>
  <style>
    body{font-family:system-ui;background:#0b1224;color:#eaf2ff;padding:40px;}
    a{color:#00f5d4;font-weight:700;text-decoration:none;}
    .box{max-width:900px;margin:auto;background:rgba(255,255,255,0.05);padding:30px;border-radius:18px;border:1px solid rgba(255,255,255,0.10);}
  </style>
</head>
<body>
  <div class="box">
    <h1>About This App</h1>
    <p>
      This is a Spring Boot app deployed using GitHub Actions CI/CD pipeline.
    </p>
    <p>
      <a href="/">⬅ Back to Home</a>
    </p>
  </div>
</body>
</html>
        """;
    }

    // HEALTH CHECK (Good for Kubernetes readiness)
    @GetMapping("/health")
    public String health() {
        return "OK - " + LocalDate.now();
    }

    // JSON API
    @GetMapping("/api/info")
    public Map<String, Object> info() {
        return Map.of(
                "app", "Kastro DevOps Bootcamp",
                "topic", "GitHub Actions + Kubernetes",
                "batchStart", "29 January 2026",
                "status", "RUNNING"
        );
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
