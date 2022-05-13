# Jogo de Cartas API

Esta API REST permite o acesso aos jogadores, listas e cartas.

Recursos disponíveis para acesso via API:
* [**Jogador**](#reference/recursos/jogador)
* [**Lista**](#reference/recursos/lista)
* [**Carta**](#reference/recursos/carta)

## Métodos
Requisições para a API devem seguir os padrões:
| Método | Descrição |
|---|---|
| `GET` | Retorna informações de um ou mais registros. |
| `POST` | Utilizado para criar um novo registro. |
| `PUT` | Atualiza dados de um registro ou altera sua situação. |
| `DELETE` | Remove um registro do sistema. |

# Jogador [/jogadores]

Os jogadores possuem usuário e senha.

### Novo (Create) [POST]

+ Attributes (object)

    + usuario: nome do jogador (string, required)
    + senha (string, required)

+ Request (application/json)

    + Body

            {
              "usuario":"maria",
              "senha":"123"
            }

+ Response 200 (application/json)

    + Body

            {
              "codUsuario": "maria",
              "listas": []
            }

### Detalhar (Read) [GET /jogadores?usuario={usuario}]

+ Request (application/json)

    + Params

            usuario: [usuario]

+ Response 200 (application/json)

          {
            "codUsuario": "maria",
            "listas": []
          }

# Lista [/listas]

São listas que os jogadores possuem de suas cartas.


### Listar (List) [GET /listas?sort={value}]

+ Request (application/json)

  + Query Params
            
            sort: [value]

+ Response 200 (application/json)

            [
              {
                  "id": 1,
                  "cartas": [
                      {
                          "id": 2,
                          "nome": "evee",
                          "edicao": 1,
                          "idioma": "portugues",
                          "foil": true,
                          "preco": "R$2.000,00",
                          "quantidade": 1
                      }
                  ],
                  "nome": "fogo"
              },
              {
                  "id": 2,
                  "cartas": [],
                  "nome": "agua"
              }
            ]

### Novo (Create) [POST]

+ Request (application/json)

    + Body

                {
                  "nome":"agua",
                  "jogador" : {
                      "usuario": "maria"
                      }
                }

+ Response 200 (application/json)

    + Body

            {
              "id": 3,
              "cartas": [],
              "nome": "vento"
            }

### Detalhar (Read) [GET /listas/{id}?sort={value}]

+ Request (application/json)

  + Parameters
      + id (required, number, `1`) ... Código da lista

  + Query Params
      +  sort: [value]

+ Response 200 (application/json)

    + Body

            {
              "id": 1,
              "cartas": [
                  {
                      "id": 2,
                      "nome": "evee",
                      "edicao": 1,
                      "idioma": "portugues",
                      "foil": true,
                      "preco": "R$2.000,00",
                      "quantidade": 1
                  }
              ],
              "nome": "fogo"
            }

+ Response 404 (application/json)
 Quando o registro não foi encontrado.

    + Body

            {
              "timestamp": "2022-05-13T01:07:04.830+00:00",
              "status": 404,
              "error": "Not Found",
              "message": "Erro ao resgatar lista: 404 NOT_FOUND \"Lista não localizada.\"",
              "path": "/listas/4"
            }
# Carta [/cartas]

São cartas que os jogadores possuem.

### Novo (Create) [POST]

+ Request (application/json)

    + Body

            {
              "lista" : 
                  {"id": 1},    
              "nome": "evee",
              "edicao": 1,
              "idioma": "portugues",
              "foil" : true,
              "preco" : "R$2.000,00",
              "quantidade" : 1
            }

+ Response 200 (application/json)

    + Body

            {
                "id": 2,
                "nome": "evee",
                "edicao": 1,
                "idioma": "portugues",
                "foil": true,
                "preco": "R$2.000,00",
                "quantidade": 1
            }

### Editar (Update) [PUT /cartas/{id}]

+ Request (application/json)

  + Parameters
      + id (required, number, `1`) ... id da carta.

  + Body

            {
              "preco" : 2.000,
              "quantidade" : 10
            }

+ Response 200 (application/json)

+ Response 404 (application/json)
 Quando o registro não foi encontrado.

    + Body

            {
              "timestamp": "2022-05-13T01:11:46.525+00:00",
              "status": 500,
              "error": "Internal Server Error",
              "message": "Erro ao atualizar carta: 404 NOT_FOUND \"Carta não localizada.\"",
              "path": "/cartas/1"
            }

### Remover (Delete) [DELETE  /cartas/{id}]

+ Request (application/json)

    + Parameters
      + id (required, number, `1`) ... id da carta.

+ Response 200 (application/json)