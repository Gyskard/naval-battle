package game_ressources;

class Game {

    Game(int size, String pseudo) {
        Human_Player ThePlayer = new Human_Player(size, pseudo);
        IA_Player TheIA = new IA_Player(size, ThePlayer);
        TheIA.getGameBoard().setVisible(false);

    }

}