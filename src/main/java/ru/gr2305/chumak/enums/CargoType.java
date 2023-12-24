package ru.gr2305.chumak.enums;

public enum CargoType {
    LIQUID, // Жидкость
    SOLID, // Твердые вещества
    GAS, // Газы
    PERISHABLE, // Продукты, требующие особой осторожности в хранении
    HAZARDOUS; // Опасные грузы


    @Override
    public String toString() {
        switch (this){
            case GAS -> {
                return "Газы";
            }
            case SOLID -> {
                return "Твердые вещества";
            }
            case LIQUID -> {
                return "Жидкость";
            }
            case HAZARDOUS -> {
                return "Опасные грузы";
            }
            case PERISHABLE -> {
                return "Продукты, требующие особой осторожности в хранении";
            }
            default -> {
                return "Не указан";
            }
        }
    }
}
