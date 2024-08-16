Bibliotecas Utilizadas
Spring Boot
Spring Reactive Web
Spring Data R2DBC
H2 Database
Validation I/O
Estrutura do Projeto
Place: Define a entidade do domínio, suas propriedades e outros detalhes. Utiliza o record em vez de class para facilitar e reduzir a verbosidade na criação de objetos imutáveis, o que é útil para operações CRUD. Os records são usados para objetos que possuem apenas atributos e métodos getter/setter.

PlaceRepository: É o repositório que trabalha com a entidade Place. No Spring Data, este repositório deve ser definido como uma interface.

PlaceService: Responsável pelas regras de negócio da aplicação. Utiliza o repositório que é injetado pelo Spring e implementa a operação de criação.

PlaceConfig: Configura o PlaceService.

Controlador: Define os endpoints especificados nos requisitos.

Observações
No teste inicial, o atributo id é exibido como "null" porque o valor é gerado pelo banco de dados com auto incremento, e não pelo Spring. Para evitar a exposição direta dos objetos de domínio, foi utilizado um DTO (Data Transfer Object), que é criado no pacote da API e contém apenas as propriedades que desejamos expor.

Foi aplicado o princípio SOLID para separar as responsabilidades do código, promovendo uma melhor organização e manutenção.

Após os testes iniciais, removemos a necessidade de passar as datas pelo usuário para evitar erros. A API foi ajustada para não exigir essas datas, utilizando recursos do Spring Data para gerenciar a criação e atualização automaticamente.

A necessidade de um slug foi removida. O slug, que é um identificador baseado no nome, poderia causar inconsistências entre o nome e o slug. Utilizamos a biblioteca slugify para gerar o slug automaticamente e evitar erros.

Os testes foram realizados com uma abordagem de integração fim a fim. Um ambiente web foi configurado para rodar em uma porta aleatória, testando a criação de um place com sucesso e um com erro. Um cliente web reativo foi injetado para enviar requisições, especificar o verbo, a URI e o corpo da requisição (place request com nome e estado). O JSON Path foi utilizado para verificar cada propriedade.
Instruções para Execução
Clonar o Repositório Git
    git clone > https://github.com/jorgefernandorb/place_service
Construir o Projeto
    ./mvnw clean package
Construir a Imagem Docker
    ./mvnw spring-boot:build-image
Executar o Container
    docker run --name place-service -p 8080:8080 -d place-service:0.0.1-SNAPSHOT
A API pode ser acessada em http://localhost:8080/places.
