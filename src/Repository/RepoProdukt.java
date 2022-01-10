package Repository;

import Classes.Produkt;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RepoProdukt implements ICrudRepo<Produkt> {

    private List<Produkt> repoList;

    public RepoProdukt(){
        this.repoList = new ArrayList<>();
    }


    @Override
    public List<Produkt> findAll() {

        return this.repoList;
    }

    @Override
    public Produkt findOne(Long id) {


        for (Produkt produkt : this.repoList) {
            if (Objects.equals(produkt.getId(), id))
                return produkt;
        }
        return null;
    }

    @Override
    public Produkt save(Produkt obj) {

        if (this.findOne(obj.getId()) != null)
            return obj;

        this.repoList.add(obj);
        return null;
    }

    @Override
    public Produkt update(Produkt obj)  {

        for(Produkt produkt: this.repoList){
            if(Objects.equals(produkt.getId(), obj.getId())){
                produkt.setPreis(obj.getPreis());
                produkt.setName(obj.getName());

                return null;
            }
        }

        return obj;
    }


    @Override
    public Produkt delete(Long id) {

        if (this.findOne(id) == null)
            return null;

        Produkt toDelete = this.findOne(id);
        this.repoList.remove(toDelete);
        return toDelete;
    }
}
