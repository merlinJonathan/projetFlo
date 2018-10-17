package kurzen.editeurdetexte;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;

public class MusiqueManager {
    private static MediaPlayer musiqueEnCours;

    public static void recupererCheminMusiqueDeFileExplorer(Page pageActuelle)
    {
        pageActuelle.setMusique(Uri.parse(FileExplore.mMyAppsBundle.getString("cheminAboslu")));
    }

    public static void lancerMusique(Context mContext)
    {
        // lance une musique stocké a linterieur de lappli
        if(musiqueEnCours == null)
        {
            musiqueEnCours = MediaPlayer.create(mContext, R.raw.musiquetest);
        }
        musiqueEnCours.start();
        musiqueEnCours.isLooping();
        System.out.println("===== musique lancée");
    }

    public static void lancerMusique(Context mContext, String cheminMusique)
    {
        // lance une musique stocker sur le telephone
        Uri u = Uri.parse(cheminMusique);
        musiqueEnCours = MediaPlayer.create(mContext.getApplicationContext(), u);
        lancerMusique(mContext);
    }

    public static void changerMusiqueEnCours(Context mContext, Page pageActuelle)
    {
        // lance la musique de la page
        musiqueEnCours.stop();
        musiqueEnCours = MediaPlayer.create(mContext, pageActuelle.getMusique());
        lancerMusique(mContext);
    }
}
