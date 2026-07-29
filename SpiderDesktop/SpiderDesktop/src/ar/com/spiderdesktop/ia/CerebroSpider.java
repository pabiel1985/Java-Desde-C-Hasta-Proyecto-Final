package ar.com.spiderdesktop.ia;

import ar.com.spiderdesktop.spider.EstadoSpider;
import ar.com.spiderdesktop.spider.Spider;

public class CerebroSpider {

    private Spider spider;

    public CerebroSpider(Spider spider) {
        this.spider = spider;
    }

    public void actualizar() {

        spider.actualizar();

        if (spider.llegoAlObjetivo()) {
            spider.setEstado(EstadoSpider.DESCANSANDO);
        }

    }

}