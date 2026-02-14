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

    @GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
    public String home() {
        return """
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>Learn With Kastro | DevOps Masterclass</title>

  <style>
    :root{
      --bg:#070A12;
      --bg2:#0B1224;
      --card: rgba(255,255,255,0.06);
      --border: rgba(255,255,255,0.12);
      --text:#EAF2FF;
      --muted: rgba(234,242,255,0.65);
      --primary:#00F5D4;
      --secondary:#FFB703;
      --blue:#3A86FF;
      --danger:#ff4d6d;
      --radius: 22px;
      --shadow: 0 25px 80px rgba(0,0,0,0.55);
      --transition: 0.25s ease;
    }

    body.light{
      --bg:#f4f7ff;
      --bg2:#ffffff;
      --card: rgba(0,0,0,0.04);
      --border: rgba(0,0,0,0.10);
      --text:#0b1224;
      --muted: rgba(0,0,0,0.55);
      --shadow: 0 20px 60px rgba(0,0,0,0.12);
    }

    *{margin:0;padding:0;box-sizing:border-box;}
    body{
      font-family: system-ui, -apple-system, Segoe UI, Roboto, Arial, sans-serif;
      color: var(--text);
      background:
        radial-gradient(circle at 20% 10%, rgba(58,134,255,0.16), transparent 40%),
        radial-gradient(circle at 80% 60%, rgba(0,245,212,0.12), transparent 45%),
        linear-gradient(180deg, var(--bg), var(--bg2));
      min-height:100vh;
      overflow-x:hidden;
      transition: var(--transition);
    }

    /* Header */
    header{
      position: sticky;
      top: 0;
      z-index: 999;
      backdrop-filter: blur(14px);
      background: rgba(0,0,0,0.25);
      border-bottom: 1px solid rgba(255,255,255,0.06);
    }

    body.light header{
      background: rgba(255,255,255,0.65);
      border-bottom: 1px solid rgba(0,0,0,0.06);
    }

    .nav{
      max-width: 1200px;
      margin: 0 auto;
      padding: 18px 20px;
      display:flex;
      align-items:center;
      justify-content:space-between;
      gap:20px;
    }

    .brand{
      display:flex;
      align-items:center;
      gap:12px;
      font-weight:900;
      letter-spacing:0.5px;
    }

    .logo{
      width:44px;height:44px;border-radius:16px;
      background: linear-gradient(135deg, var(--primary), var(--blue));
      box-shadow: 0 0 45px rgba(0,245,212,0.25);
    }

    .nav-links{
      display:flex;
      gap:18px;
      align-items:center;
      flex-wrap:wrap;
    }

    .nav-links a{
      text-decoration:none;
      color: var(--muted);
      font-weight:700;
      transition: var(--transition);
    }
    .nav-links a:hover{color: var(--primary);}

    .toggle{
      border: 1px solid var(--border);
      background: var(--card);
      color: var(--text);
      padding: 10px 14px;
      border-radius: 14px;
      cursor:pointer;
      font-weight:800;
      transition: var(--transition);
    }
    .toggle:hover{transform: translateY(-2px);}

    /* Layout */
    .wrap{
      max-width: 1200px;
      margin: 0 auto;
      padding: 40px 20px 80px;
    }

    /* Hero */
    .hero{
      display:grid;
      grid-template-columns: 1.1fr 0.9fr;
      gap:26px;
      align-items:stretch;
      margin-top: 30px;
    }

    .hero-left{
      padding: 28px;
      border-radius: var(--radius);
      background: var(--card);
      border: 1px solid var(--border);
      box-shadow: var(--shadow);
      overflow:hidden;
      position:relative;
    }

    .hero-left:before{
      content:'';
      position:absolute;
      inset:-50px;
      background: radial-gradient(circle, rgba(0,245,212,0.14), transparent 55%);
      z-index:-1;
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
      font-weight:800;
      letter-spacing:1px;
      font-size:0.95rem;
    }

    h1{
      margin-top:18px;
      font-size:3.1rem;
      line-height:1.05;
      font-weight:950;
      background: linear-gradient(90deg, var(--primary), var(--blue), var(--secondary));
      -webkit-background-clip:text;
      background-clip:text;
      color:transparent;
    }

    .subtitle{
      margin-top:18px;
      color: var(--muted);
      font-size:1.2rem;
      line-height:1.75;
      max-width: 720px;
    }

    .cta-row{
      display:flex;
      gap:14px;
      flex-wrap:wrap;
      margin-top:24px;
    }

    .btn{
      padding:15px 18px;
      border-radius: 18px;
      font-weight:900;
      text-decoration:none;
      border:1px solid var(--border);
      transition: var(--transition);
      display:inline-flex;
      align-items:center;
      gap:10px;
      cursor:pointer;
    }

    .btn-primary{
      background: linear-gradient(135deg, var(--secondary), #ff7b00);
      color:#111;
      border:none;
      box-shadow: 0 18px 45px rgba(255,183,3,0.25);
    }
    .btn-primary:hover{transform: translateY(-3px);}

    .btn-ghost{
      background: rgba(255,255,255,0.03);
      color: var(--text);
    }
    .btn-ghost:hover{
      border-color: rgba(0,245,212,0.25);
      transform: translateY(-3px);
    }

    /* Right side */
    .hero-right{
      display:grid;
      gap:16px;
    }

    .card{
      background: var(--card);
      border: 1px solid var(--border);
      border-radius: var(--radius);
      padding: 22px;
      box-shadow: var(--shadow);
    }

    .card h3{
      font-size: 1.35rem;
      margin-bottom: 10px;
      color: var(--primary);
    }

    .muted{color: var(--muted);}

    .countdown{
      display:grid;
      grid-template-columns: repeat(4, 1fr);
      gap:12px;
      margin-top: 16px;
    }

    .cd{
      background: rgba(255,255,255,0.03);
      border: 1px solid rgba(255,255,255,0.08);
      border-radius: 18px;
      padding: 14px 12px;
      text-align:center;
    }

    .cd .num{
      font-size: 1.8rem;
      font-weight: 950;
      color: var(--secondary);
    }
    .cd .lbl{
      font-size: 0.9rem;
      opacity: 0.75;
      margin-top: 4px;
    }

    /* Stats */
    .stats{
      margin-top: 26px;
      display:grid;
      grid-template-columns: repeat(4, 1fr);
      gap:16px;
    }

    .stat{
      padding: 18px;
      border-radius: 22px;
      background: rgba(255,255,255,0.04);
      border: 1px solid rgba(255,255,255,0.08);
      text-align:center;
      transition: var(--transition);
    }
    .stat:hover{
      transform: translateY(-8px);
      border-color: rgba(0,245,212,0.20);
    }
    .stat .num{
      font-size: 2.2rem;
      font-weight: 950;
      color: var(--primary);
    }
    .stat .lbl{
      color: var(--muted);
      margin-top: 6px;
      font-weight:700;
    }

    /* Curriculum */
    .section{
      margin-top: 55px;
    }

    .section-title{
      font-size: 2rem;
      font-weight: 950;
      margin-bottom: 16px;
    }

    .grid-2{
      display:grid;
      grid-template-columns: 1fr 1fr;
      gap:16px;
    }

    .pill{
      display:inline-flex;
      padding:10px 14px;
      border-radius:999px;
      font-weight:800;
      margin: 6px 8px 0 0;
      border: 1px solid rgba(255,255,255,0.10);
      background: rgba(255,255,255,0.04);
      color: var(--text);
    }

    /* FAQ */
    .faq-item{
      border: 1px solid rgba(255,255,255,0.10);
      border-radius: 18px;
      margin-bottom: 12px;
      overflow:hidden;
      background: rgba(255,255,255,0.03);
    }
    .faq-q{
      padding: 16px 16px;
      cursor:pointer;
      font-weight:900;
      display:flex;
      justify-content:space-between;
      align-items:center;
    }
    .faq-a{
      padding: 0 16px 16px;
      color: var(--muted);
      display:none;
      line-height:1.7;
    }
    .faq-item.open .faq-a{display:block;}

    /* Modal */
    .modal{
      position: fixed;
      inset:0;
      background: rgba(0,0,0,0.65);
      display:none;
      align-items:center;
      justify-content:center;
      padding:20px;
      z-index:9999;
    }
    .modal.show{display:flex;}

    .modal-box{
      width:min(720px, 100%);
      background: var(--bg2);
      border: 1px solid rgba(255,255,255,0.12);
      border-radius: 26px;
      padding: 26px;
      box-shadow: 0 35px 90px rgba(0,0,0,0.65);
    }

    .modal-box h2{
      font-size: 1.7rem;
      font-weight: 950;
      margin-bottom: 10px;
    }

    .close{
      float:right;
      cursor:pointer;
      font-size: 1.4rem;
      font-weight: 950;
      opacity:0.8;
    }
    .close:hover{opacity:1;}

    /* Footer */
    footer{
      margin-top: 70px;
      border-top: 1px solid rgba(255,255,255,0.08);
      padding-top: 30px;
      color: rgba(234,242,255,0.55);
      display:flex;
      justify-content:space-between;
      gap:20px;
      flex-wrap:wrap;
    }

    footer a{
      color: var(--primary);
      text-decoration:none;
      font-weight:800;
    }
    footer a:hover{text-decoration:underline;}

    @media(max-width: 980px){
      .hero{grid-template-columns:1fr;}
      h1{font-size:2.4rem;}
      .stats{grid-template-columns: repeat(2, 1fr);}
      .grid-2{grid-template-columns:1fr;}
      .countdown{grid-template-columns: repeat(2, 1fr);}
    }
  </style>
</head>

<body>

<header>
  <div class="nav">
    <div class="brand">
      <div class="logo"></div>
      <span>Learn With Kastro</span>
    </di
