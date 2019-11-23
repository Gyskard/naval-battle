package game_ressources;

class Game {

    Game(String pseudo) {
        Human_Player ThePlayer = new Human_Player(pseudo);
        IA_Player TheIA = new IA_Player(ThePlayer);
        ThePlayer.setAdversary(TheIA);

        /*
        while(ThePlayer.boatAlive!=0 || TheIA.boatAlive!=0 )
        {

        }

         */
    }
}