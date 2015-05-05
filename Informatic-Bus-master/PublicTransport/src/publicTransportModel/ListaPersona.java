/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publicTransportModel;

import java.util.Arrays;

/**
 *
 * @author CASPED
 */
public class ListaPersona {
    public Person[] persona;
    private int amountPersona;
    
    public ListaPersona(){
        persona = new Person[200];
        amountPersona = 0;
    }
    
    public int getAmountpersona(){
        return amountPersona;
    }
    
    public void addPerson(Person person){
        int indexPerson = this.searchPerson(person);
        if(indexPerson == -1){
            persona[amountPersona]=person;
            amountPersona++;
            Arrays.sort(persona,0,amountPersona);
        }
    }
    
    private int searchPerson(Person person) {
        int indexPerson = -1;
        for (int i = 0; i < amountPersona; i++) {
            if(persona[i]!=null&&persona[i].equals(person)) {
                indexPerson = i;
            }
        }
        return indexPerson;
    }
    
    public void removePerson(Person person){
        int positionPerson=this.searchPerson(person);
        if(positionPerson!=-1){
            persona[positionPerson] =  null;
            for(int i=positionPerson;i<amountPersona;i++){
                persona[i]=persona[i+1];
            }
            amountPersona--;
        }
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj==null||obj.getClass()!=this.getClass()) {
            return false;
        }
        
        ListaPersona ListaPersonaCompare = (ListaPersona) obj;
        
        boolean sonEquals=false;
        if (this.amountPersona==ListaPersonaCompare.amountPersona){
            for(int i=0;i<amountPersona;i++){
                sonEquals=sonEquals && this.persona[i].equals(ListaPersonaCompare.persona[i]);
            }                           
            sonEquals=true;
        }
        return sonEquals;
    }
}
