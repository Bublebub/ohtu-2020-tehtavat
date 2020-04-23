
package ohtu;

public class Player {
    private String name, team, nationality, birthdate;
    private Integer goals, assists, penalties;
    
    //-----------------------Setters----------------------------------
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setGoals(Integer goals) {
        this.goals = goals;
    }
    
    public void setAssists(Integer assists) {
        this.assists = assists;
    }
    
    public void setPenalties(Integer penalties) {
        this.penalties = penalties;
    }
    
    public void setTeam(String team) {
        this.team = team;
    }
    
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    
    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
    
    //-----------------------Getters----------------------------------

    public String getName() {
        return name;
    }
    
    public Integer getGoals() {
        return goals;
    }
    
    public Integer getAssists() {
        return assists;
    }
    
    public Integer getPenalties() {
        return penalties;
    }
    
    public String getTeam() {
        return team;
    }
    
    public String getNationality() {
        return nationality;
    }
    
    public String getBirthdate() {
        return birthdate;
    }
    
    //-----------------------Other----------------------------------

    @Override
    public String toString() {
        return name;
    }
      
}
