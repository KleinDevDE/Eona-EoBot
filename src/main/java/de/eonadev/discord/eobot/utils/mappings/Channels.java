package de.eonadev.discord.eobot.utils.mappings;

import de.eonadev.discord.eobot.utils.ProdDevWorker;

public enum Channels {
    VERIFY(555433904635510789L),
    WELCOME(585876730305183762L),
    ANKUENDIGUNGEN(537362265310232594L),
    NICE2KNOW(542002364408922122L),
    REGELN(539398649944211486L),
    LOBBY(546438490590674950L),
    ENTWURF(551698656038748416L),
    EONACHAT(539398439184760832L),
    ALLGEMEIN(551696893424566282L),
    CHAT_ECKE_1(554201468303966209L),
    CHAT_ECKE_2(554201632242532353L),
    CHAT_ECKE_3(554201661745135616L),
    HYDRA_SONGREQUESTS(616356869434245133L),
    BILDER(640876384931282944L),
    PROJEKT_THEMONA(571384209805934592L),
    EONA_GAMES_CHAT(554203851385995264L),
    GAME_CHAT(554203775318097942L),
    TEAMERCHAT(539504919099604992L),
    TEAM_NEWS(544130617772867594L),
    TEAM_TECHNIK(544159856878288897L),
    TEAM_INGAME(554202426127810600L),
    TEAM_WEB(554202464644235276L),
    BANNHAMMER(555348714894655508L),
    BAUPROJEKTE(555347606923116574L),
    IDEEN(555348955026685977L),
    BUGS(551495392269959178L),
    PLUGINIDEEN(555349525594898442L),
    PROJEKTE(551495252226342920L),
    YOUTUBE_FUER_ALLE(555349223843823617L),
    WIKIARTIKEL(555349799981940746L),
    ANFRAGEN(673266737340481546L),
    GIT(538079761642291240L),
    BANSYSTEM(538079837915709461L),
    LUCKPERMS(538080417136508928L),
    AUTHSYSTEM(538080941017399296L),
    EOCORE(552901141319647243L),
    KUMMERKASTEN(689973164490752077L),
    TEST(542076162143158273L),
    DELETED_MESSAGES(585562006023569418L),
    MOD_LOG(539481637809815552L);

    long channelID;

    Channels(long id) {
        this.channelID = id;
    }

    public long getChannelID() {
        return ProdDevWorker.getChannelID(channelID);
    }
}
