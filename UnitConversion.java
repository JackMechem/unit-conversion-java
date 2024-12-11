import java.util.Scanner;
import java.util.List;

public class UnitConversion {

    // Unit Enum of supported units
    enum UnitEnum {
        INCH, FOOT, YARD, MILE, MILLIMETER, CENTIMETER, METER, KILOMETER
    }

    // Object for the unit and value
    static class UnitObj {
        protected UnitEnum unit;
        protected double unitValue;
    }

    // Displays avaliable units and prompts user to select unit
    public static UnitEnum userSelectUnit(Scanner scanner) {

        // Convert UnitEnum to a list, which can be looped through
        List<UnitEnum> unitsList = java.util.Arrays.asList(UnitEnum.values());

        // Loop through UnitEnum
        for (UnitEnum unitElement : unitsList) {
            System.out.println("(" + unitsList.indexOf(unitElement) + ") " + unitElement);
        }
        // Prompt User
        System.out.print("Select Unit (0 - " + (unitsList.size() - 1) + "): ");

        // Get index from user
        int userIndex = scanner.nextInt();

        return unitsList.get(userIndex);
    }

    // Function that converts the given unit to millimeters, then to the desired
    // unit, and returns a UnitObj object.
    public static UnitObj convert(UnitObj fromUnit, UnitEnum toUnit) {
        UnitObj result = new UnitObj();
        result.unit = toUnit;

        // For simplicity, convert to millimeters first
        double mmValue = 0;
        switch (fromUnit.unit) {
            case INCH:
                mmValue = fromUnit.unitValue * 25.4;
                break;
            case FOOT:
                mmValue = fromUnit.unitValue * 304.8;
                break;
            case YARD:
                mmValue = fromUnit.unitValue * 914.4;
                break;
            case MILE:
                mmValue = fromUnit.unitValue * 1609000;
                break;
            case MILLIMETER:
                mmValue = fromUnit.unitValue;
                break;
            case CENTIMETER:
                mmValue = fromUnit.unitValue * 10;
                break;
            case METER:
                mmValue = fromUnit.unitValue * 1000;
                break;
            case KILOMETER:
                mmValue = fromUnit.unitValue * 1000000;
                break;
            default:
                break;
        }

        // Then convert to the desired unit (from millimeters)
        switch (toUnit) {
            case INCH:
                result.unitValue = mmValue / 25.4;
                break;
            case FOOT:
                result.unitValue = mmValue / 304.8;
                break;
            case YARD:
                result.unitValue = mmValue / 914.4;
                break;
            case MILE:
                result.unitValue = mmValue / 1609000;
                break;
            case MILLIMETER:
                result.unitValue = mmValue;
                break;
            case CENTIMETER:
                result.unitValue = mmValue / 10;
                break;
            case METER:
                result.unitValue = mmValue / 1000;
                break;
            case KILOMETER:
                result.unitValue = mmValue / 1000000;
                break;
            default:
                break;
        }

        return result;
    }

    public static void main(String[] args) {
        // Create scanner object
        Scanner scnr = new Scanner(System.in);

        // Create given unit object and unit to convert to
        UnitObj fromUnitObj = new UnitObj();
        UnitEnum toUnit;

        // Get unit to convert from user
        System.out.println("Select Unit to Convert From: ");
        fromUnitObj.unit = userSelectUnit(scnr);

        // Get value of the unit to convert from user
        System.out.print("Enter Its Value: ");
        fromUnitObj.unitValue = scnr.nextDouble();

        // Get unit to convert to from user
        System.out.println("Select Unit to Convert To: ");
        toUnit = userSelectUnit(scnr);

        // Call convert function with user input
        UnitObj conversion = convert(fromUnitObj, toUnit);

        // Display result
        System.out.println("Result: \n" + conversion.unitValue + " " + conversion.unit);

        // Close scanner and return
        scnr.close();
        return;
    }
}
