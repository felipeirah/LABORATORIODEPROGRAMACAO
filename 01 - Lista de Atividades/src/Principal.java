public class Principal {

    public static void main(String[] args) {

        Heroi goku = new Goku();
        Heroi sonic = new Sonic();
        Heroi mario = new Mario();

        goku.setNome("Son Goku");
        goku.setVida(1000);
        goku.setEnergia(8000);

        sonic.setNome("Sonic");
        sonic.setVida(950);
        sonic.setEnergia(5500);

        mario.setNome("Mario");
        mario.setVida(500);
        mario.setEnergia(750);

        goku.apresentar();
        goku.atacar();

        sonic.apresentar();
        sonic.atacar();

        mario.apresentar();
        mario.atacar();
    }
}