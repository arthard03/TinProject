package tin.tinproject.DTO;

public class GuildDTO {

    private Long guildID;
    private String name;
    private String description;
    private Integer members;

    public Long getGuildID() {
        return guildID;
    }

    public void setGuildID(Long guildID) {
        this.guildID = guildID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getMembers() {
        return members;
    }

    public void setMembers(Integer members) {
        this.members = members;
    }
}