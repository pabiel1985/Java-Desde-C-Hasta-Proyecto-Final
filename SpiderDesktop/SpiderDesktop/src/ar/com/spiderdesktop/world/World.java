package ar.com.spiderdesktop.world;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class World {

    private List<Fly> moscas = new ArrayList<>();

    private Random random = new Random();

    public void agregarMosca(Fly mosca) {

        moscas.add(mosca);

    }

    public List<Fly> getMoscas() {

        return moscas;

    }

    public Fly crearMoscaAleatoria() {

        double x = random.nextInt(700) + 50;
        double y = random.nextInt(500) + 50;

        Fly mosca = new Fly(x, y);

        moscas.add(mosca);

        return mosca;

    }
    
    public void revivirMosca() {

        if (moscas.isEmpty()) {
            return;
        }

        double x = random.nextInt(700) + 50;
        double y = random.nextInt(500) + 50;

        moscas.get(0).revivir(x, y);

    }

    public void actualizar() {

        for (Fly mosca : moscas) {

            mosca.actualizar();

        }

    }

}