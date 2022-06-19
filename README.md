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
 
> 💡 Atividade III: implementar CRUD para usuários, veículos, serviços, peças e vendas, com total autonomia de desenvolvedor chefe, porém algumas funcionalidades acodadas são imprescindíveis:
> - ✔️ cadastro deempresa (unidade comercial que oferece o serviço de manutenção e venda de mercadorias);
> - ✔️ associação de usuários a uma determinada empresa;
> - ✔️ tipos de usuários no sistema com "cliente", "fornecedor" e "funcionário" 
> - ✔️ inclusão de credencial para acesso de um usuário ao sistema
 
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
## :railway_track: Rotas disponíveis para operações de gerenciamento

<details>
 <summary>Endpoints disponíveis para gerenciamento de <b>Usuários</b></summary>
 <br>
<div align="center">
 
| Situação                 |  Resultado                                                                                                 |
| :----------------------- | :--------------------------------------------------------------------------------------------------------- | 
| Novo cliente             | ![](https://user-images.githubusercontent.com/69374340/174503668-75c77c8a-9a8d-4e0f-b177-290ad977d7e7.png) |
| Novo funcionário         | ![](https://user-images.githubusercontent.com/69374340/174503706-4438e66e-a373-4778-af65-819ffaa2c372.png) |
| Todos os usuários        | ![](https://user-images.githubusercontent.com/69374340/174503750-3d13dc7e-a274-4db2-9e93-a5a5ca2b81b6.png) |
| Todos os clientes        | ![](https://user-images.githubusercontent.com/69374340/174503769-b77e03f0-bddb-4fbd-b1ee-d9d4e7e1cd86.png) |
| Todos os funcionários    | ![](https://user-images.githubusercontent.com/69374340/174503780-2b973f0c-cecd-43ad-8aa2-39f6113abce8.png) |
| Usuário específico       | ![](https://user-images.githubusercontent.com/69374340/174503812-fb98024e-b5a7-4c44-ad78-6e8c714f5412.png) |
| Alterar dados de usuário | ![](https://user-images.githubusercontent.com/69374340/174503832-f565ebc3-3703-44b4-9979-8921c86ba712.png) |
| Excluir usuário          | ![](https://user-images.githubusercontent.com/69374340/174503846-91118942-afc1-47be-96cb-b2e7338ab47b.png) |
</div>
</details>
 
<details>
 <summary>Endpoints disponíveis para gerenciamento de <b>Marcas de Veículos</b></summary>
 <br>
<div align="center">
 
| Situação               |  Resultado                                                                                                 |
| :--------------------- | :--------------------------------------------------------------------------------------------------------- | 
| Nova marca             | ![](https://user-images.githubusercontent.com/69374340/174503941-2f0a0148-356f-4dd4-960c-3f97b29ddaec.png) |
| Todas as marcas        | ![](https://user-images.githubusercontent.com/69374340/174503948-c269829e-182c-4472-9f04-4ef7b4d8afed.png) |
| Marca específica       | ![](https://user-images.githubusercontent.com/69374340/174503965-20f0889e-6541-47c5-bc3a-f2dcf913a7ab.png) |
| Alterar dados de marca | ![](https://user-images.githubusercontent.com/69374340/174504002-72f561b5-0b10-4e39-8935-3a32fae0e4c5.png) |
| Excluir marca          | ![](https://user-images.githubusercontent.com/69374340/174504008-f6583425-daaa-4615-a5b5-8d79a3adfbbf.png) |
</div>
</details>
 
<details>
 <summary>Endpoints disponíveis para gerenciamento de <b>Veículos</b></summary>
 <br>
<div align="center">
 
| Situação               |  Resultado                                                                                                 |
| :--------------------- | :--------------------------------------------------------------------------------------------------------- | 
| Novo veículo           | ![](https://user-images.githubusercontent.com/69374340/174504138-3faec7fa-34da-41ec-b0ac-3523c27e4807.png) |
| Todos os veículos      | ![](https://user-images.githubusercontent.com/69374340/174504168-24d08007-b0ed-4208-833c-832793db0305.png) |
| Veículo específico     | ![](https://user-images.githubusercontent.com/69374340/174504188-d617587e-5097-4def-a47c-c9d6768d2c7c.png) |
| Alterar ano do veículo | ![](https://user-images.githubusercontent.com/69374340/174504228-58dbfb30-f17e-4b50-ac37-0e66c8360f24.png) |
| Excluir veículo        | ![](https://user-images.githubusercontent.com/69374340/174504255-3c24cb91-e202-4edf-8357-2924343b1d97.png) |
</div>
</details>
 
<details>
 <summary>Endpoints disponíveis para gerenciamento de <b>Produtos</b></summary>
 <br>
<div align="center">
 
| Situação                     |  Resultado                                                                                                 |
| :--------------------------- | :--------------------------------------------------------------------------------------------------------- | 
| Novo produto                 | ![](https://user-images.githubusercontent.com/69374340/174504287-94d9b630-85d0-4ffe-9584-31b1bcfb51ad.png) |
| Todos os produtos            | ![](https://user-images.githubusercontent.com/69374340/174504299-2b123e71-cfd5-4103-9067-f76a4b802d03.png) |
| Todos os produtos de um tipo | ![](https://user-images.githubusercontent.com/69374340/174504310-ec3b68f6-b557-4d4b-a7f5-07260e4e38f8.png) |
| Produto específico           | ![](https://user-images.githubusercontent.com/69374340/174504318-d05bee91-776a-4e6c-88a2-c540901f075d.png) |
| Alterar nome de produto      | ![](https://user-images.githubusercontent.com/69374340/174504343-5fb77284-80fb-45bc-926a-3d9c21d14b3f.png) |
| Excluir produto              | ![](https://user-images.githubusercontent.com/69374340/174504351-316ff31b-8ab9-4404-b9f5-b39b13585e2b.png) |
</div>
</details>
 
<details>
 <summary>Endpoints disponíveis para gerenciamento de <b>Serviços</b></summary>
 <br>
<div align="center">
 
| Situação                     |  Resultado                 |
| :--------------------------- | :------------------------- | 
| Novo serviço                 | ![]() |
| Todos os serviços            | ![]() |
| Todos os serviços de um tipo | ![]() |
| Serviço específico           | ![]() |
| Alterar nome de serviço      | ![]() |
| Excluir serviço              | ![]() |
</div>
</details>
 
<details>
 <summary>Endpoints disponíveis para gerenciamento de <b>Vendas</b></summary>
 <br>
<div align="center">
 
| Situação                                    |  Resultado                 |
| :------------------------------------------ | :------------------------- | 
| Nova venda                                  | ![]() |
| Todas as vendas                             | ![]() |
| Todos as vendas que um funcionário realizou | ![]() |
| Todos as vendas que um cliente realizou     | ![]() |
| Venda específica                            | ![]() |
</div>
</details>
 
<details>
 <summary>Endpoints disponíveis para gerenciamento de <b>Empresas</b></summary>
 <br>
<div align="center">
 
| Situação                       |  Resultado                 |
| :----------------------------- | :------------------------- | 
| Nova empresa                   | ![]() |
| Todas as empresas              | ![]() |
| Empresa específica             | ![]() |
| Associar usuário a uma empresa | ![]() |
| Associar produto a uma empresa | ![]() |
| Associar serviço a uma empresa | ![]() |
| Associar venda a uma empresa   | ![]() |
| Alterar nome de empresa        | ![]() |
| Excluir empresa                | ![]() |
</div>
</details>

[![image](https://img.shields.io/badge/✨%20Maria%20Gabriela%20Reis,%202022-LinkedIn-009973?style=flat-square)](https://www.linkedin.com/in/mariagabrielareis/)
