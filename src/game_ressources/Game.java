package game_ressources;

import java.io.IOException;

class Game {

    Game(String pseudo) throws IOException {
        Human_Player ThePlayer = new Human_Player(pseudo);
        IA_Player TheIA = new IA_Player(ThePlayer);
        ThePlayer.setAdversary(TheIA);

    }
}