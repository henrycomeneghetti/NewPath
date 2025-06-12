# Projeto Java - NewPath

---

## ✅ Requisitos

- Java 18
- Apache NetBeans 24 (ou compatível)
- MySQL instalado e em execução
- Biblioteca MySQL Connector (já incluída)
- Fazer a configuração da conexão com o banco de dados

---

## 🚀 Como abrir o projeto

1. Abra o NetBeans.
2. Vá em **`File > Open Project`**.
3. Selecione a pasta `newpath`.

---

## ⚙️ Configuração da conexão com o banco de dados

1. Abra a classe `ConexaoBD.java`.
2. Edite as seguintes linhas com os dados do seu MySQL local:

```java
private static String USERNAME = "seu_usuario_mysql"; // Linha 17
private static String PASSWORD = "sua_senha_mysql";   // Linha 18
private static String URL = "sua_url_para_0_mysql" + DB_NOME; // Linha 21
💡 Se estiver em dúvida, mantenha a URL como está e teste a conexão.

▶️ Como executar o projeto
Clique com o botão direito no projeto newpath no painel esquerdo.

Selecione Run ou clique no botão ▶️ na barra superior.

👤 Usuário administrador padrão
Login: admin
Senha: 1234

🔒 Como alterar o login/senha do administrador:
Acesse a classe TelaLogin.java.

Vá até a linha 187 e modifique as credenciais diretamente no código.

📚 Bibliotecas
O conector MySQL (mysql-connector-j-9.3.0.jar) já está incluso na pasta lib/.

Se ocorrer erro de biblioteca:

Vá até Propriedades do Projeto > Bibliotecas.

Remova a biblioteca quebrada (se existir).

Clique em Adicionar JAR/Pasta e selecione lib/mysql-connector-j-9.3.0.jar.

❗ Observações
O banco de dados newpath é criado automaticamente ao iniciar o programa, se não existir.

O login admin é apenas para testes locais, substitua ou proteja em produção.

//

Desenvolvido por: Henryco Meneghetti de Queiróz
LinkedIn: https://www.linkedin.com/in/henryco-meneghetti-1659b035b/