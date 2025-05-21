# 6.1 Analyse

## 1. @ApplicationScoped / @ApplicationScoped / @Dependent
Service bleibt bestehen → HashMap bleibt bestehen → Daten persistent zwischen Requests

## 2. @RequestScoped / @ApplicationScoped / @Dependent  
Nur Resource wird neu erstellt, Service bleibt → Daten persistent (Service ist der wichtige Teil)

## 3. @ApplicationScoped / @RequestScoped / @Dependent
Service wird pro Request neu erstellt → neue HashMap pro Request → Daten weg nach jedem Request

## 4. @RequestScoped / @RequestScoped / @Dependent
Beide neu pro Request → neue HashMap pro Request → Daten weg nach jedem Request

**Fazit:** Service-Scope entscheidet, weil da die HashMap lebt. ApplicationScoped = Daten bleiben, RequestScoped = Daten weg.