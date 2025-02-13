package data;

/**
 * Clase que representa los cálculos relacionados con el salario de un empleado.
 * Esta clase incluye métodos para calcular el salario mensual, décimo tercer sueldo, utilidades,
 * horas extras y fondos de reserva de acuerdo a la legislación laboral.
 */
public class Salario {

    /**
     * Calcula el salario mensual de un empleado, tomando en cuenta el salario base, 
     * las horas trabajadas, los bonos y los descuentos.
     * El salario base se ajusta por las horas trabajadas, considerando una jornada laboral de 160 horas mensuales.
     *
     * @param SALARIO_BASE El salario base del empleado.
     * @param horasTrabajadas Las horas trabajadas por el empleado durante el mes.
     * @param bonos Los bonos adicionales que recibe el empleado.
     * @param descuentos Los descuentos aplicados al salario.
     * @return El salario neto mensual calculado.
     */
    public double calcularRolPagos(double salarioBase, double horasTrabajadas, double bonos, double descuentos) {
        return salarioBase + (horasTrabajadas * salarioBase / 160) + bonos - descuentos;
    }

    /**
     * Calcula el décimo tercer sueldo, que corresponde a 1/12 del salario base.
     * 
     * @param SALARIO_BASE El salario base del empleado.
     * @return El valor del décimo tercer sueldo.
     */
    public double calcularDecimoTercerSueldo(double salarioBase) {
        return salarioBase / 12; 
        // Se divide el salario base entre 12 meses
    }

    /**
     * Calcula las utilidades que le corresponden al empleado, las cuales son proporcionales 
     * a los meses trabajados durante el año.
     * 
     * @param SALARIO_BASE El salario base del empleado.
     * @param mesesTrabajados La cantidad de meses que el empleado ha trabajado durante el año.
     * @return El valor de las utilidades.
     */
    public double calcularUtilidades(double salarioBase, int mesesTrabajados) {
        return (salarioBase * mesesTrabajados) / 12; 
        // Proporcional a los meses trabajados
    }

    /**
     * Calcula el pago por horas extras, tomando en cuenta que se paga al 150% del valor 
     * normal de la hora.
     * 
     * @param SALARIO_BASE El salario base del empleado.
     * @param horasExtras La cantidad de horas extras trabajadas.
     * @return El pago por horas extras.
     */
    public double calcularHorasExtras(double salarioBase, double horasExtras) {
        return (salarioBase / 160) * 1.5 * horasExtras; 
        // Pago de horas extras al 150%
    }

    /**
     * Calcula los fondos de reserva, que es una cantidad equivalente a 1/12 del salario base 
     * similar al décimo tercer sueldo.
     * 
     * @param SALARIO_BASE El salario base del empleado.
     * @return El valor de los fondos de reserva.
     */
    public double calcularFondosReserva(double salarioBase) {
        return salarioBase / 12;
        // Similar al décimo tercer sueldo
    }
}
