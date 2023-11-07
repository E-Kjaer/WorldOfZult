/* World class for modeling the entire in-game world
 */

import java.util.ArrayList;

public class World {
    private Space entry;
    private ArrayList<Group> groups;

    // Constructor
    public World () {
        // Adds items
        Item lys = new Item("Lyspære", "Denne pære udsender specifikke bølgelængder af lys, " +
                "ofte blåt og rødt, som er afgørende for fotosyntese og plantevækst." +
                " Dette er også kaldet et vækstlys.");
        Item  vandingssystem = new Item("Vandingssystem","Vandingssystemet opsættes på en farm," +
                " hvor afgrøderne ikke får nok vand fra naturen til at kunne gro." +
                " Dette gør ellers golde områder til frugtbar jord.");
        Item biokul = new Item("Biokul","Biokul modvirker dårlig jordkvalitet," +
                " som er et problem i nogle lande. Bedre jordkvalitet gør, at man kan dyrke flere varianter" +
                " af afgrøder.");
        Item maskine = new Item("Såmaskine", "Anvendes til såning af korn eller frø.");
        Item opbevaringskasse = new Item("Opbevaringskasse", "Denne boks skærmer for vind og vejr," +
                " hvilket forlænger holdbarheden af maden.");


        // Adds groups
        Group groupDrivhus = new Group(lys, "Hej spiller, her dyrker vi grøntsager," +
                " som f.eks. tomater, agurker og peberfrugter. Vores grøntsager vokser bedst, " +
                "når der er meget dagslys. Desværre kan vi ikke styre vejret eller hvornår solen går" +
                " ned, så vi er meget afhængige af sæsonerne.");
        Group groupVand = new Group(vandingssystem, "Hey spiller, her på vores gård dyrkes der forskellige typer frugter," +
                " alt fra citrusfrugter til æbler. Mange af de høstede frugter er næsten uspiselige," +
                " da de ender som små gnallinger. Der er nemlig ret tørt, der hvor vi dyrker.  " +
                "Vi laver en regndans hver morgen, men det ser desværre ikke ud til at virke.");
        Group groupKul = new Group(biokul, "Hej spiller, vi har rigtigt meget landbrugsjord, " +
                "som vi rigtigt gerne vil dyrke vores afgrøder på. Vi har dog et stort problem, som forhindrer os i at dyrke noget på det. " +
                "Jordkvaliteten er for dårlig til at vores planter kan gro i det. Vil du hjælpe os?");
        Group groupMaskine = new Group(maskine, "Hej spiller, vi er landmænd, og gror korn. " +
                "Vi har længe selv stået for at så vores korn, men det tager lang tid og processen er hård." +
                " Kan du komme i tanke om en maskine som ville kunne hjælpe med at så korn mere effektivt?");
        Group groupOpbevaringskasse = new Group(opbevaringskasse, "Hej spiller, vi har nogle afgrøder" +
                " som producerer dejlig mad. Vi spiser så meget af det som vi kan komme til, men maden fordærver desværre for hurtigt til at vi kan" +
                " spise det hele. Vi ville ønske at maden holdt lidt længere.");

        // Adds groups to the list of groups
        this.groups = new ArrayList<Group>();
        groups.add(groupDrivhus);
        groups.add(groupVand);
        groups.add(groupKul);
        groups.add(groupMaskine);
        groups.add(groupOpbevaringskasse);
        

        // Adds rooms
        Space entry  = new Space("Indgang", "Du befinder dig i indgangen til World of Zult");
        Space space1 = new Space("Strand", "Her er der en flot strand med hvidt sand og turkisblåt vand. Det ligner, at der er et koralrev lidt længere ude.\n");
        Space space2 = new Space("Monsunland", "Her ligger et lille landbrugssamfund, vejret er vådt og varmt.\n", groupOpbevaringskasse);
        Space space3 = new Space("Eng", "Der er en vidtstrækkende eng med højt græs og vilde blomster. En å snor sig langsomt gennem landskabet.\n");
        Space space4 = new Space("Bondegård", "En bondegård med en gruppe landmænd og en tom mark. \n", groupMaskine);
        Space space5 = new Space("Jordland", "Her er et land med meget dårlig jordkvalitet.\n", groupKul);
        Space space6 = new Space("Frugtplantage", "Her er der en stor frugtplantage med flinke mennesker, men der er godt nok tørt.\n", groupVand);
        Space space7 = new Space("Bjergkæde", "Du står ved bunden af en bjergkæde. De sneklædte bjerge er kilometer høje og toppene er gemt bagved et lag skyer.\n");
        Space space8 = new Space("Drivhus-land", "Her er en gård med flere drivhuse. Ved det ene drivhus står to personer. \n", groupDrivhus);

        space1.addItem(biokul);
        space5.addItem(opbevaringskasse);
        space7.addItem(vandingssystem);
        space8.addItem(maskine);
        space3.addItem(lys);

        entry.addEdge("syd", space2);
        space2.addEdge("nord", entry);
        space2.addEdge("øst", space3);
        space2.addEdge("syd", space6);
        space2.addEdge("vest", space1);
        space1.addEdge("øst", space2);
        space1.addEdge("syd", space5);
        space3.addEdge("vest", space2);
        space3.addEdge("øst", space4);
        space4.addEdge("sydvest", space7);
        space4.addEdge("vest", space3);
        space5.addEdge("nord", space1);
        space5.addEdge("øst", space6);
        space6.addEdge("nord", space2);
        space6.addEdge("øst", space7);
        space6.addEdge("vest", space5);
        space7.addEdge("vest", space6);
        space7.addEdge("nordøst", space4);
        space7.addEdge("syd", space8);
        space8.addEdge("nord", space7);

        /*
        Space sea = new Space("Sea", "This is the sea", groupSea);
        Space grassLand = new Space("Grassland", "This is the grasslands", groupGrass);
        Space dirtLand      = new Space("Dirtland", "This is dirty", groupLand);
        Space outside  = new Space("Outside", "This, unlike the other places, is the outside");


        // Adds items to the spaces
        sea.addItem(tractor);
        grassLand.addItem(fishingRod);
        dirtLand.addItem(scythe);

        // Adds edges, which is the paths between rooms
        entry.addEdge("door", sea);
        sea.addEdge("door", grassLand);
        grassLand.addEdge("north", dirtLand);
        grassLand.addEdge("south", outside);
        grassLand.addEdge("east", sea);
        dirtLand.addEdge("door", grassLand);
        outside.addEdge("door", grassLand);
        */
        this.entry = entry;
    }

    // Get spawnpoint / entry to the world
    public Space getEntry () {
        return entry;
    }

    // Get list of groups
    public ArrayList<Group> getGroups() {
        return groups;
    }
}

