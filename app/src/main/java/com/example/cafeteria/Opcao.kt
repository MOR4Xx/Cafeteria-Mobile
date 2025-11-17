package com.example.cafeteria

data class Opcao(val titulo: String, val descricao: String? = null, val imagem: Int? = null)

object OpcoesMenu {
    fun getOpcoesMenu(): List<Opcao> {
        return listOf(
            Opcao("Bebidas"), Opcao("Comidas"), Opcao("Mercearia")
        )
    }
}

object OpcoesBebidas {
    fun getBebidas(): List<Opcao> {
        return listOf(
            Opcao(
                "Espresso",
                "Um café forte e concentrado feito ao forçar água quente através de café moído fino. Base de várias outras bebidas de café.",
                R.drawable.cafeteria
            ), Opcao(
                "Cappuccino",
                "Combina espresso com partes iguais de leite vaporizado e espuma de leite. Famoso pelo equilíbrio entre sabores ricos e textura cremosa."
            ), Opcao(
               "Latte",
                "Uma dose de espresso com uma quantidade generosa de leite vaporizado e uma pequena camada de espuma por cima. Suave e levemente adocicado."
            ), Opcao(
                "Americano",
                "Espresso diluído com água quente, resultando em um café mais suave e menos intenso. Popular entre quem gosta de sabores menos concentrados."
            ), Opcao(
                "Mocha",
                "Mistura de espresso com leite vaporizado e uma dose de chocolate. Geralmente coberto com chantilly e popular entre os amantes de chocolate."
            ), Opcao(
                titulo = "Macchiato",
                descricao = "Espresso 'manchado' com um pouco de espuma de leite, acentuando o sabor forte do café com apenas um toque de suavidade."
            ), Opcao(
                titulo = "Flat White",
                descricao = "Similar ao cappuccino, mas com menos espuma e uma proporção maior de leite. De origem australiana, tem sabor intenso e textura sedosa."
            ), Opcao(
                titulo = "Ristretto",
                descricao = "Uma dose de espresso mais concentrada e curta, com sabor mais denso e encorpado. Ideal para quem gosta de café intenso."
            ), Opcao(
                titulo = "Affogato",
                descricao = "Uma sobremesa italiana que combina espresso quente sobre uma bola de sorvete de baunilha. Uma deliciosa fusão de quente e frio."
            ), Opcao(
                titulo = "Cold Brew",
                descricao = "Café preparado com infusão em água fria por 12–24 horas, resultando em um sabor suave e menos ácido. Servido gelado."
            )
        )

    }
}