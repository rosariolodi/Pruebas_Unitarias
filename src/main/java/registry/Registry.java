package registry;

import java.util.ArrayList;
import java.util.List;

public class Registry {

    private List<Integer> registeredPersons = new ArrayList<>();

    public RegisterResult registerVoter(Persona p){

        if(!p.isAlive()){
            return RegisterResult.DEAD;
        }
        if(registeredPersons.contains(p.getId())){
            return RegisterResult.DUPLICATED;
        }
        if(p.getAge()<18 && p.getAge()>0){
            return RegisterResult.UNDERAGE;
        }
        else if(p.getAge()<0 || p.getAge()>120){
            return RegisterResult.INVALID_AGE;
        }
        else{
            registeredPersons.add(p.getId());
            return RegisterResult.VALID;

        }



    }

}
