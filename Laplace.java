public class Laplace
{   static int  Nmax =  100; 
    public static void main(String[] argv) throws IOException, FileNotFoundException {   
    double U[][] = new double[Nmax][Nmax];
    int i, j, iter;
    /*-//Sauvegarde des données dans Laplace.dat-*/
    PrintWriter w = new PrintWriter(new FileOutputStream("Laplace.dat"), true); 
    for (i=0; i< Nmax; i++)      /*++-//Initialisation du tableau-++*/
    { for (j=0; j< Nmax; j++) { U[i][j] = 0.0; } }
    for (i = 25; i<= 75; i++)  /*++-//intervalles++-*/
    {   U[i][37] = -100.0; /*++-//Assiette parallèle des potentiels-++*/
        U[i][63] = 100.0;  }
    for (i = 0; i< Nmax; i++) /*++-//potentiel box-++*/
    {   U[0][i] = 0.0;
        U[Nmax-1][i] = 0.0; 
        U[i][0] = 0.0;
        U[i][Nmax-1] = 0.0; 
    } 
    for (iter=0; iter< 1000; iter++) /*++-//iteration tous les 1000 -++*/
    {   for (i=1; i<=Nmax-2; i++) {  /*++-//x-direction-++*/
        for(j=1; j<= Nmax-2; j++) {  /*++-//y-direction-++*/
            U[i][j] = 0.25*(U[i+1][j] + U[i-1][j] + U[i][j+1] + U[i][j-1]);
            if (j==37 && i>=25 && i<=75) U[i][j] = 100.0;  
            if (j==63 && i>=25 && i<=75) U[i][j] = -100.0 ;
    }}}
    for (i=0; i<Nmax ; i=i+2) { /*++-//Ecriture des données format 3D pour GnuPlot-++*/
        for (j=0; j<Nmax; j=j+2) {
        w.println(""+U[i][j]+"");
        w.println(""); /*++-//ligne blanche pour separer les colonnes puor GnuPlot-++*/
     }}
    System.out.println("donnees sauvegardees dans Laplace.dat");
    } /*++-//fin main-++*/
}    /*++-// fin class-++*/
