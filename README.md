# login
Simples autenticação de login utilizando Spring e o SpringSecurity
Olá,

Nesse pequeno projeto utlizei Spring, 
o foco foi treinar a questão da segurança juntamente com o SpringSecurity, facilitou para entender seus conceitos e estrutura. No mesmo projeto estou utlizando JPA
para a criação da tabela usuario, estou usando as validations para definir as constraints dos campos, utilizei thymeleaf no frontend, criação de services, repository e 
uma classe que está populando registros na tabela para me servirem como massa de Teste. Para o SpringSecurity configurei o mesmo em uma classe utilizando a annotation @Configuration,
modelei uma classe LoggedUser, ela implementa a interface UserDetails e lá passo o usuário em um construtor e vou utlizando implementando os métodos conforme as minhas necessidade,
crie um enum de Roles, apesar de ter apenas 1 tipo de usuário achei melhor mesmo assim criar esse enum pra deixar mais padronizado, criei um classe Utils para questões de segurança, 
nela eu pego o usuário autenticado e podendo até converter em um Usuário, pois uma vez que essa Utils me retorna um LoggedUser eu já consigo obter um objeto do tipo Usuario e por fim,
foi criado também uma classe AuthenticationSuccessHandlerImpl que irá implementar a AuthenticationSuccessHandler, com ela eu sobrescrevo o método onAuthenticationSuccess, nele eu uso a SecurityUtils para obter
uma Role, com essa Role eu faço uma verificação pra eu saber qual tipo de Usuario está acessando, aí com isso, consigo levar o mesmo para página por meio do Response, por exemplo uma /home

Essa solução eu utilizei apenas 1 tipo de usuário mesmo para ficar bem simples o entendimento, porém ela é perfeita para ter vários tipos de usuário, crie um enum de Role pra cada tipo de Usuário e com isso
e com isso você pode ter vários redirecionamentos diferentes, quanto mais roles, mais verificação terá pra definir o destino da response.

Espero que tenha ajudado um pouco, estou aberto a criticas e até melhorias, sou um mega, super pequeno gafanho kk... Então, toda ajuda é bem vinda. até mais
