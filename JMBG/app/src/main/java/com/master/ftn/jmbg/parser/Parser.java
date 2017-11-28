package com.master.ftn.jmbg.parser;

/**
 * Created by Loshmi on 11/28/2017.
 */

public class Parser
{
    public static String getDOB (String jmbg)
    {
        int godina = Integer.parseInt(jmbg.substring(4, 7));
        if (godina < 800) godina += 2000;
        else godina += 1000;
        return jmbg.substring(0, 2) + "." + jmbg.substring(2, 4) + "." + godina + ".";
    }
    public static String getSex (String jmbg)
    {
        int broj = Integer.parseInt(jmbg.substring(9, 12));

        if (broj >= 0 && broj < 500) return "Muski";
        return "Zenski";
    }

    public static int getNumber (String jmbg)
    {
        return Integer.parseInt(jmbg.substring(9, 12)) % 500 + 1;
    }

    public static String getLocation (String jmbg)
    {
        int locationCode = Integer.parseInt(jmbg.substring(7, 9));

        switch (locationCode)
        {
            case 1: return "stranac, rodjen u BiH";
            case 2: return "stranac, rodjen u Crnoj Gori";
            case 3: return "stranac, rodjen u Hrvatskoj";
            case 4: return "stranac, rodjen u Makedoniji";
            case 5: return "stranac, rodjen u Sloveniji";
            case 7: return "stranac, rodjen u centralnoj Srbiji)";
            case 8: return "stranac, rodjen u Vojvodini";
            case 9: return "stranac, rodjen na Kosovu";
            case 10: return "Bosna i Hercegovina, Banja Luka";
            case 11: return "Bosna i Hercegovina, Bihac";
            case 12: return "Bosna i Hercegovina, Doboj";
            case 13: return "Bosna i Hercegovina, Gorazde";
            case 14: return "Bosna i Hercegovina, Livno";
            case 15: return "Bosna i Hercegovina, Mostar";
            case 16: return "Bosna i Hercegovina, Prijedor";
            case 17: return "Bosna i Hercegovina, Sarajevo";
            case 18: return "Bosna i Hercegovina, Tuzla";
            case 19: return "Bosna i Hercegovina, Zenica";
            case 21: return "Crna Gora, Podgorica";
            case 26: return "Crna Gora, Niksic";
            case 29: return "Crna Gora, Pljevlja";
            case 30: return "Hrvatska, Osijek, Slavonija region";
            case 31: return "Hrvatska, Bjelovar, Virovitica, Koprivnica, Pakrac, Podravina region";
            case 32: return "Hrvatska, Varaždin, Međimurje region";
            case 33: return "Hrvatska, Zagreb";
            case 34: return "Hrvatska, Karlovac";
            case 35: return "Hrvatska, Gospić, Lika region";
            case 36: return "Hrvatska, Rijeka, Pula, Istra and Primorje region";
            case 37: return "Hrvatska, Sisak, Banovina region";
            case 38: return "Hrvatska, Split, Zadar, Dubrovnik, Dalmacija region";
            case 39: return "Hrvatska";
            case 41: return "Makedonija, Bitola";
            case 42: return "Makedonija, Kumanovo";
            case 43: return "Makedonija, Ohrid";
            case 44: return "Makedonija, Prilep";
            case 45: return "Makedonija, Skopje";
            case 46: return "Makedonija, Strumica";
            case 47: return "Makedonija, Tetovo";
            case 48: return "Makedonija, Veles";
            case 49: return "Makedonija, Štip";
            case 50: return "Slovenija";
            case 71: return "Srbija, Beograd region (Grad Beograd: Stari Grad, Savski Venac, Voždovac, Vračar, Palilula, Zvezdara, Rakovica, Čukarica, Novi Beograd, Zemun, Mladenovac, Barajevo, Grocka, Obrenovac, Sopot, Lazarevac)";
            case 72: return "Srbija, Šumadija i Pomoravlje regions (Šumadijski okrug: Aranđelovac, Batočina, Knić, Kragujevac, Rača, Lapovo, Topola), (Pomoravski okrug: Despotovac, Paraćin, Rekovac, Jagodina, Svilajnac, Ćuprija)";
            case 73: return "Srbija, Niš region (Nišavski okrug: Aleksinac, Svrljig, Niš, Gadžin Han, Doljevac, Merošina, Ražanj), (Pirotski okrug: Babušnica, Bela Palanka, Dimitrovgrad, Pirot), (Toplički okrug: Blace, Žitorađa, Prokuplje, Kuršumlija)";
            case 74: return "Srbija, Južna Morava region (Jablanički okrug: Leskovac, Vlasotince, Medveđa, Lebane, Bojnik, Crna Trava), (Pčinjski okrug: Vranje, Bujanovac, Surdulica, Bosilegrad, Preševo, Trgovište, Vladičin Han)";
            case 75: return "Srbija, Zaječar region (Zaječarski okrug: Zaječar, Boljevac, Knjaževac, Sokobanja), (Borski okrug: Bor, Majdanpek, Kladovo, Negotin)";
            case 76: return "Srbija, Podunavlje region (Podunavski okrug: Smederevska Palanka, Velika Plana, Smederevo), (Braničevski okrug: Veliko Gradište, Kučevo, Petrovac na Mlavi, Požarevac, Žagubica, Golubac, Žabari, Malo Crniće)";
            case 77: return "Srbija, Podrinje i Kolubara regions (Mačvanski okrug: Loznica, Krupanj, Ljubovija, Šabac, Bogatić, Koceljeva, Vladimirci, Mali Zvornik), (Kolubarski okrug: Valjevo, Lajkovac, Ljig, Ub, Osečina, Mionoca)";
            case 78: return "Srbija, Kraljevo region (Raški okrug: Kraljevo, Vrnjačka Banja, Novi Pazar, Raška, Tutin), (Moravički okrug: Gornji Milanovac, Čačak, Ivanjica, Lučani), (Rasinski okrug: Aleksandrovac, Brus, Kruševac, Trstenik, Varvarin, Ćićevac)";
            case 79: return "Srbija, Užice region (Zlatiborski okrug: Arilje, Bajina Bašta, Kosjerić, Nova Varoš, Požega, Priboj, Prijepolje, Sjenica, Užice, Čajetina)";
            case 80: return "Vojvodina, Novi Sad region (Južnobački okrug: Bač, Bačka Palanka, Bački Petrovac, Vrbas, Žabalj, Novi Sad, Srbobran, Sremski Karlovci, Temerin, Titel, Bečej, Beočin)";
            case 81: return "Vojvodina, Sombor region (Zapadnobački okrug: Apatin, Kula, Odžaci, Sombor)";
            case 82: return "Vojvodina, Subotica region (Severnobački okrug: Bačka Topola, Subotica, Mali Iđoš)";
            case 83: return "Vojvodina, Vrbas";
            case 85: return "Vojvodina, Zrenjanin region (Srednjebanatski okrug: Zrenjanin, Nova Crnja, Novi Bečej, Sečanj, Žitište)";
            case 86: return "Vojvodina, Pančevo region (Južnobanatski okrug: Alibunar, Bela Crkva, Vršac, Kovačica, Kovin, Pančevo, Opovo, Plandište)";
            case 87: return "Vojvodina, Kikinda region (Severnobanatski okrug: Ada, Kikinda, Kanjiža, Novi Kneževac, Senta, Čoka)";
            case 88: return "Vojvodina, Ruma region (Sremski okrug: Inđija, Pećinci, Ruma, Sremska Mitrovica, Stara Pazova, Šid, Irig)";
            case 89: return "Vojvodina, Sremska Mitrovica region (Sremski okrug: Inđija, Pećinci, Ruma, Sremska Mitrovica, Stara Pazova, Šid, Irig)";
            case 91: return "Kosovo, Priština region (Kosovski okrug: Priština, Obilić, Podujevo, Štrpce, Lipljan, Glogovac, Kačanik, Kosovo Polje, Uroševac, Štimlje)";
            case 92: return "Kosovo, Kosovska Mitrovica region (Kosovsko Mitrovački okrug: Kosovska Mitrovica, Zvečan, Leposavić, Zubin Potok, Vučitrn, Srbica)";
            case 93: return "Kosovo, Peć region (Pećki okrug: Peć, Istok, Klina)";
            case 94: return "Kosovo, Đakovica region (Pećki okrug: Dečani, Đakovica)";
            case 95: return "Kosovo, Prizren region (Prizrenski okrug: Gora-Dragaš, Orahovac, Prizren, Suva Reka)";
            case 96: return "Kosovo, Kosovsko Pomoravski okrug: (Gnjilane, Kosovska Kamenica, Vitina, Novo Brdo)";
            default: return "";
        }
    }
}
