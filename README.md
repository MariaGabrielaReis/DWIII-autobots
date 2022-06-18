<h1 align="center">
 🚘🛠️ Autobots 🛠️🚘
</h1>

<p align="center">
  <a href="#projeto">Sobre o projeto</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#requisitos">Como rodar</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#demo">Demonstração</a>
</p>

<span id="projeto">
  
# :bookmark_tabs: Sobre o projeto
Este é um sistema para gerenciamento de uma loja de autopeças que consiste em uma API baseada na arquitetura de microsserviço com Java, aplicando conceitos do SOLID e padrões de projeto adequados que possibilitam listagem, cadastro, exclusão e alteração de informações sobre clientes, produtos, serviços, veículos e marcas de veículos.
 
> 💡 Atividade II: implementar os níveis de maturidade de uma API RESTful
> - ✔️ uso do protocolo HTTP
> - ✔️ URI única por recurso
> - ✔️ uso dos métodos e suas semânticas 
> - ✔️ aplicação de HATEOAS

## :railway_track: Rotas disponíveis para operações de gerenciamento
<div align="center">

| Ação                | Tipo   | Clientes <br> `/customers` | Veículos <br> `/vehicles` | Produtos <br> `/products` | Marcas de Veículos <br> `/vehicle/brands` |
| :------------------ | :----- | :------------------------- | :------------------------ | :------------------------ | :---------------------------------------- |
| Listagem geral      | [![image](https://img.shields.io/badge/GET-2E8B57?style=for-the-badge)]()   |<a href=''>/</a>      |<a href=''>/</a>      | <a href=''>/</a>      |<a href=''>/</a>                       | 
| Listagem específica | [![image](https://img.shields.io/badge/GET-2E8B57?style=for-the-badge)]()   |<a href=''>/{id}</a>  |<a href=''>/{id}</a>  | <a href=''>/{id}</a>  |<a href=''>/{id}</a>                   |
| Cadastro            | [![image](https://img.shields.io/badge/POST-4682B4?style=for-the-badge)]()  |<a href=''>/create</a>|<a href=''>/create</a>| <a href=''>/create</a> <a href=''>/create</a>                 
| Alteração           | [![image](https://img.shields.io/badge/PUT-9370DB?style=for-the-badge)]()   |<a href=''>/update</a>|<a href=''>/update</a>| <a href=''>/update</a>|<a href=''>/update</a>                 |
| Exclusão            | [![image](https://img.shields.io/badge/DELETE-CD853F?style=for-the-badge)]()|<a href=''>/delete</a>|<a href=''>/delete</a>| <a href=''>/delete</a>|<a href=''>/delete</a>                 |
  
</div>

<span id="requisitos">

# :gear: Como rodar
Para executar o projeto é preciso que o Java e o Git estejam instalados. Para conferir a instalação do Java para Linux, acesse [este tutorial](https://docs.oracle.com/en/java/javase/11/install/installation-jdk-linux-platforms.html#GUID-737A84E4-2EFF-4D38-8E60-3E29D1B884B8), já para Windows acesse [este link](https://docs.oracle.com/en/java/javase/11/install/installation-jdk-microsoft-windows-platforms.html#GUID-A7E27B90-A28D-4237-9383-A58B416071CA). Após os downloads, baixe ou clone este repositório e siga o passo a passo descrito abaixo, pelo terminal:

```bash
# Acesse a pasta do projeto
$ cd DWIII-autobots

# Espere o Maven carregar as dependências do projeto (são listadas no arquivo pom.xml)

# Execute o projeto utilizando sua IDE preferida (Eclipse, VS Code, IntelliJ, etc.)
```

O servidor inciará localmente na porta 8080. Utilize o Insomnia ou o Postman para simular requisições e respostas das rotas (pelo link [https://localhost:8080](https://localhost:8080)).

<span id="demo">
  
# :desktop_computer: Demonstração
Na tabela abaixo é possível observar uma demonstração do uso dos endpoints criados e as aplicações dos níveis de maturidade de APIs RESTful, como URIs únicas por recurso, uso correto dos status code e HATEOAS.
> **Observação:** O controller escolhido para os testes foi o de clientes, porém as mesmas técnicas foram aplicadas para os outros endpoints como de veículos, produtos, marcas e etc.
  
| Situação                   |  Resultado                 |
| :------------------------- | :------------------------- | 
| Obtenção de todos os clientes, porém sem clientes cadastrados | ![](https://user-images.githubusercontent.com/69374340/174419479-6eff4c96-2c80-4836-81c2-cfc97b5c49c5.png)|
| Cadastro de um cliente | ![](https://user-images.githubusercontent.com/69374340/174419505-2f6e17ed-6cbd-4916-9241-5fe25bde1876.png) |
| Obtenção de todos os clientes, agora com um cliente cadastrado | ![](https://user-images.githubusercontent.com/69374340/174419518-a7ef2ff6-f6c4-4384-9eb9-18fcd76407b0.png) |
| Atualização de nome do cliente | ![](https://user-images.githubusercontent.com/69374340/174419563-c6019a12-4bec-4a97-afe9-3909f7ae4bb0.png) |
| Atualização de cliente com id inexistente | ![](https://user-images.githubusercontent.com/69374340/174419586-7b2ecf8f-b35f-4e90-8f9d-59e5b54a8f3e.png) |
| Exclusão de um cliente | ![](https://user-images.githubusercontent.com/69374340/174419618-837ce14d-ef83-46ad-9f42-d3c5892da153.png) |

[![image](https://img.shields.io/badge/✨%20Maria%20Gabriela%20Reis,%202022-LinkedIn-009973?style=flat-square)](https://www.linkedin.com/in/mariagabrielareis/)
