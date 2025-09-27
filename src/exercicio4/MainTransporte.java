package exercicio4;

public class MainTransporte {
    public static void main(String[] args) {
        try {
            IMeioTransporte carro = new Carro();
            IMeioTransporte bicicleta = new Bicicleta();
            IMeioTransporte trem = new Trem();

//            carro.frear();  // Simular erro ao tentar frear com velocidade 0
            carro.acelerar();
            carro.acelerar();
            carro.acelerar();
            carro.frear();
            carro.acelerar();
            carro.acelerar();
            carro.acelerar();
            carro.acelerar();
            carro.acelerar();
            carro.acelerar();
//            carro.acelerar(); // Excede velocidade máxima do carro

            System.out.println("==============================");
            for (int i = 0; i < 3; i++) {
                bicicleta.acelerar();
            }
            bicicleta.frear();

            System.out.println("==============================");
            trem.acelerar();
            trem.acelerar();
            trem.acelerar();
            trem.acelerar();
            trem.acelerar();
            trem.frear();
            trem.frear();

        } catch (VelocidadeInvalidaException e) {
            System.out.println(e.getMessage());
        }
    }
}
