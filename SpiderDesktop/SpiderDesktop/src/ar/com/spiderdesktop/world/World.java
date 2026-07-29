package ar.com.spiderdesktop.world;

import java.util.ArrayList;
import java.util.List;

public class World {

    private List<Fly> moscas = new ArrayList<>();

    public void agregarMosca(Fly mosca) {

        moscas.add(mosca);

    }

    public List<Fly> getMoscas() {

        return moscas;

    }

}