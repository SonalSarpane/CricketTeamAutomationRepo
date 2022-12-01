package testScripts;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.*;
import java.util.ArrayList;
import pojo.Player;
import pojo.getTeamPlayers;
import com.fasterxml.jackson.databind.ObjectMapper;

public class checkForeignPlayerCount {
    ObjectMapper objectMapper = new ObjectMapper();
    getTeamPlayers teamPlayers;
    {
        try
        {
            teamPlayers = objectMapper.readValue(new File("/Users/sonal/TestPgmAssignment/src/main/resources/testData.json"),getTeamPlayers.class);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    @Test
    public void testCase1() throws IOException {
        ArrayList<Player> listOfPlayers=teamPlayers.getPlayer();
        int cntForeignPlayers=0;
        for(int i=0;i< listOfPlayers.size();i++){
            if(listOfPlayers.get(i).getCountry().equals("South Africa")||listOfPlayers.get(i).getCountry().equals("Australia")||
                    listOfPlayers.get(i).getCountry().equals("Srilanka")){
                cntForeignPlayers++;
            }
        }
        Assert.assertEquals(4, cntForeignPlayers);
    }

    @Test
    public void testCase2(){
        ArrayList<Player> listOfPlayers=teamPlayers.getPlayer();
        int cntWicketKeeper=0;
        for(int j=0;j<listOfPlayers.size();j++){
            if(listOfPlayers.get(j).getRole().equals("Wicket-keeper")){
                cntWicketKeeper++;
            }
        }
        if(cntWicketKeeper==0){
            System.out.println("Team has No wicket keeper");
        }
        Assert.assertEquals(1, cntWicketKeeper);
        System.out.println("Team has " + cntWicketKeeper +" wicket keeper");
    }
}
