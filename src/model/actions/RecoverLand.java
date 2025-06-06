package model.actions;

import model.entitas.Player;
import model.calendar.GameCalendar;
import model.map.FarmMap;
import model.items.Point;

public class RecoverLand extends Action {
    private Player player;
    private GameCalendar calendar;
    private FarmMap farmMap;
    private Point targetTile;

    public RecoverLand(Player player, GameCalendar calendar, FarmMap farmMap, Point targetTile) {
        super("Recover Land", "Mengubah soil menjadi land", "Pickaxe");
        this.player = player;
        this.calendar = calendar;
        this.farmMap = farmMap;
        this.targetTile = targetTile;
    }

    @Override
    public String execute() {
        if (player.getEnergy() < getEnergyCost() && player.getEnergy() > -20) {
        } else if (player.getEnergy() <= -20) {
            return "Not enough energy!";
        }
        if (player.getInventory().getItemCountByName(this.itemNeeded) == 0) {
            return "Missing item: " + this.itemNeeded;
        }
        if (farmMap.getTileType(targetTile.getY(), targetTile.getX()) != 't') {
            return "Can only recover tilled soil.";
        }

        player.setEnergy(Math.max(-20, player.getEnergy() - getEnergyCost()));
        calendar.addTime(getTimeCost());
        farmMap.setTileType(targetTile.getY(), targetTile.getX(), '.');
        return "Recovered land at (" + targetTile.getX() + ", " + targetTile.getY() + "). Energy: " + player.getEnergy();
    }

    @Override
    public int getEnergyCost() {
        return 5;
    }

    @Override
    public int getTimeCost() {
        return 5;
    }
}