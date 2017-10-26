package Logica;

public class DtRanking {

    private String nickname;
    private int cant_seguidores;

    public DtRanking() {
        this.nickname = "";
        this.cant_seguidores = 0;
    }

    public DtRanking(String nickname, int cant_seguidores) {
        this.nickname = nickname;
        this.cant_seguidores = cant_seguidores;
    }

    public String getNickname() {
        return nickname;
    }

    public int getCantSeguidores() {
        return cant_seguidores;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setCantSeguidores(int cant_seguidores) {
        this.cant_seguidores = cant_seguidores;
    }

}
