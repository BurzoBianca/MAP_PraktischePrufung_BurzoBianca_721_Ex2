package Controller;

import Classes.Bestellung;
import Classes.Produkt;
import Repository.RepoBestellung;
import Repository.RepoProdukt;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Controllerr {

    private RepoProdukt repoProdukt;
    private RepoBestellung repoBestellung;

    public Controllerr(RepoProdukt repoProdukt, RepoBestellung repoBestellung) {
        this.repoProdukt = repoProdukt;
        this.repoBestellung = repoBestellung;
    }

    public Produkt addProdukt(Produkt obj){
        return this.repoProdukt.save(obj);
    }

    public Produkt deleteProdukt(Long id){
        return this.repoProdukt.delete(id);
    }

    public Produkt updateProdukt(Produkt obj){
        return this.repoProdukt.update(obj);
    }

    public Bestellung addBestellung(Bestellung obj){
        return this.repoBestellung.save(obj);
    }

    public Bestellung deleteBestellung(Long id){
        return this.repoBestellung.delete(id);
    }

    public Bestellung updateBestellung(Bestellung obj){
        return this.repoBestellung.update(obj);
    }

    public List<Bestellung> sortBestellungenBYGTotal(){
        return this.repoBestellung.findAll()
                .stream()
                .sorted(Comparator.comparingDouble(Bestellung::getTotal).reversed())
                .collect(Collectors.toList());
    }

    private Produkt findProdukt(Long id){
        return this.repoProdukt.findOne(id);
    }

    public List<Bestellung> filterBestellungenBYProdukt(Long id){
        return this.repoBestellung.findAll()
                .stream()
                .filter(bestellung -> bestellung.getProdukte().contains(this.findProdukt(id)))
                .collect(Collectors.toList());
    }


}
