package Repository;

import Classes.Bestellung;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RepoBestellung implements ICrudRepo<Bestellung>{

    private List<Bestellung> repoList;

    public RepoBestellung(){
        this.repoList = new ArrayList<>();
    }

    @Override
    public List<Bestellung> findAll() {

        return this.repoList;
    }

    @Override
    public Bestellung findOne(Long id) {


        for (Bestellung bestellung : this.repoList) {
            if (Objects.equals(bestellung.getId(), id))
                return bestellung;
        }
        return null;
    }


    @Override
    public Bestellung save(Bestellung obj) {
        if (this.findOne(obj.getId()) != null)
            return obj;

        this.repoList.add(obj);
        return null;
    }

    @Override
    public Bestellung update(Bestellung obj)  {

        for(Bestellung bestellung: this.repoList){
            if(Objects.equals(bestellung.getId(), obj.getId())){
                bestellung.setBestellnr(obj.getBestellnr());
                bestellung.setAdresse(obj.getAdresse());
                bestellung.setProdukte(obj.getProdukte());

                return null;
            }
        }

        return obj;
    }


    @Override
    public Bestellung delete(Long id) {

        if (this.findOne(id) == null)
            return null;

        Bestellung toDelete = this.findOne(id);
        this.repoList.remove(toDelete);
        return toDelete;
    }

}
