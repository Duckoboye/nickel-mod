package duckoboye.nickelmod.lists;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
// An enum that set the properties for a material (in this case the Nickel one)
public enum ToolMaterialList implements IItemTier {
    // We create the nickel sword properties here (the basic ones)
// Some properties are useless for a sword (ex: efficiency)
    femboy_sword(50.0f, 9.0f, 8000, 3, 1, ItemList.nickel);
    private float attackDamage, efficiency;
    private int durability, harvestLevel, enchantability;
    private Item repairMaterial;
    // We init all the attributes in the constructor
    private ToolMaterialList(float attackDamage, float efficiency, int durability, int harvestLevel, int
            enchantability, Item repairMaterial) {
        this.attackDamage = attackDamage;
        this.efficiency = efficiency;
        this.durability = durability;
        this.harvestLevel = harvestLevel;
        this.enchantability = enchantability;
        this.repairMaterial = repairMaterial;
    }
    @Override
    public float getAttackDamage() { return this.attackDamage; }
    @Override
    public float getEfficiency() { return this.efficiency; }
    @Override
    public int getEnchantability() { return this.enchantability; }
    @Override
    public int getHarvestLevel() { return this.harvestLevel;}
    @Override
    public int getMaxUses(){ return this.durability; }
    @Override
    public Ingredient getRepairMaterial() { return Ingredient.fromItems(this.repairMaterial); }
}