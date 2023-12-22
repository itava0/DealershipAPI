package org.pluralsight.dao;
import org.pluralsight.model.Contract;
import org.pluralsight.model.LeaseContract;
import org.pluralsight.model.SalesContract;
import org.pluralsight.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcDealership implements DealershipDao {
    private final DataSource dataSource;

    @Autowired
    public JdbcDealership(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Vehicle addVehicle(Vehicle vehicle) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO lease_contracts (vin, year, make, model, vehicle_type, color, odometer, price, sold) VALUES (?,?,?,?,?,?,?,?,?)")) {

            statement.setString(1, vehicle.getVin());
            statement.setInt(2, vehicle.getYear());
            statement.setString(3, vehicle.getMake());
            statement.setString(4, vehicle.getModel());
            statement.setString(5, vehicle.getVehicleType());
            statement.setString(6, vehicle.getColor());
            statement.setDouble(7, vehicle.getOdometer());
            statement.setDouble(8, vehicle.getPrice());
            statement.setBoolean(9, vehicle.isSold());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicle; // Assuming you want to return the inserted vehicle
    }


    public ArrayList<Vehicle> getAllVehicles() {
        ArrayList<Vehicle> cars = new ArrayList<>();
        try (   Connection connection = dataSource.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM vehicles")) {

            while (resultSet.next()) {
                Vehicle car = new Vehicle(
                        resultSet.getString("vin"),
                        resultSet.getInt("year"),
                        resultSet.getString("make"),
                        resultSet.getString("model"),
                        resultSet.getString("vehicle_type"),
                        resultSet.getString("color"),
                        resultSet.getInt("odometer"),
                        resultSet.getDouble("price"),
                        resultSet.getBoolean("sold")


                );
                cars.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }

    public ArrayList<Vehicle> getAllVehiclesByPriceRange(double min, double max) {
        ArrayList<Vehicle> cars = new ArrayList<>();
        try (   Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "SELECT * FROM vehicles WHERE price BETWEEN ? AND ?")) {

            statement.setDouble(1, min);
            statement.setDouble(2, max);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Vehicle car = new Vehicle(
                            resultSet.getString("vin"),
                            resultSet.getInt("year"),
                            resultSet.getString("make"),
                            resultSet.getString("model"),
                            resultSet.getString("vehicle_type"),
                            resultSet.getString("color"),
                            resultSet.getInt("odometer"),
                            resultSet.getDouble("price"),
                            resultSet.getBoolean("sold")
                    );
                    cars.add(car);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }


    public ArrayList<Vehicle> getVehiclesByType(String type) {
        ArrayList<Vehicle> cars = new ArrayList<>();
        try (   Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "SELECT * FROM vehicles WHERE vehicle_Type=?")) {

            statement.setString(1, type);


            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Vehicle car = new Vehicle(
                            resultSet.getString("vin"),
                            resultSet.getInt("year"),
                            resultSet.getString("make"),
                            resultSet.getString("model"),
                            resultSet.getString("vehicle_type"),
                            resultSet.getString("color"),
                            resultSet.getInt("odometer"),
                            resultSet.getDouble("price"),
                            resultSet.getBoolean("sold")
                    );
                    cars.add(car);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }

    public ArrayList<Vehicle> getVehiclesByMilage(int minMiles, int maxMiles) {
        ArrayList<Vehicle> cars = new ArrayList<>();
        try (   Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "SELECT * FROM vehicles WHERE odometer BETWEEN ? AND ?")) {

            statement.setDouble(1, minMiles);
            statement.setDouble(2, maxMiles);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Vehicle car = new Vehicle(
                            resultSet.getString("vin"),
                            resultSet.getInt("year"),
                            resultSet.getString("make"),
                            resultSet.getString("model"),
                            resultSet.getString("vehicle_type"),
                            resultSet.getString("color"),
                            resultSet.getInt("odometer"),
                            resultSet.getDouble("price"),
                            resultSet.getBoolean("sold")
                    );
                    cars.add(car);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }

    public ArrayList<Vehicle> getVehiclesByColor(String color) {
        ArrayList<Vehicle> cars = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT * FROM vehicles WHERE color=?")) {

            statement.setString(1, color);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Vehicle car = new Vehicle(
                            resultSet.getString("vin"),
                            resultSet.getInt("year"),
                            resultSet.getString("make"),
                            resultSet.getString("model"),
                            resultSet.getString("vehicle_type"),
                            resultSet.getString("color"),
                            resultSet.getInt("odometer"),
                            resultSet.getDouble("price"),
                            resultSet.getBoolean("sold")
                    );
                    cars.add(car);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }

    public ArrayList<Vehicle> getVehiclesByYear(int min, int max) {
        ArrayList<Vehicle> cars = new ArrayList<>();
        try (   Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "SELECT * FROM vehicles WHERE year BETWEEN ? AND ?")) {

            statement.setDouble(1, min);
            statement.setDouble(2, max);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Vehicle car = new Vehicle(
                            resultSet.getString("vin"),
                            resultSet.getInt("year"),
                            resultSet.getString("make"),
                            resultSet.getString("model"),
                            resultSet.getString("vehicle_type"),
                            resultSet.getString("color"),
                            resultSet.getInt("odometer"),
                            resultSet.getDouble("price"),
                            resultSet.getBoolean("sold")
                    );
                    cars.add(car);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }

    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model) {


        ArrayList<Vehicle> cars = new ArrayList<>();
        try (   Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "SELECT * FROM vehicles WHERE make=? AND model=?")) {

            statement.setString(1, make);
            statement.setString(2, model);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Vehicle car = new Vehicle(
                            resultSet.getString("vin"),
                            resultSet.getInt("year"),
                            resultSet.getString("make"),
                            resultSet.getString("model"),
                            resultSet.getString("vehicle_type"),
                            resultSet.getString("color"),
                            resultSet.getInt("odometer"),
                            resultSet.getDouble("price"),
                            resultSet.getBoolean("sold")
                    );
                    cars.add(car);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }


    public Vehicle getVehicleByVin(String vin) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT * FROM vehicles WHERE vin=?")) {

            statement.setString(1, vin);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Vehicle(
                            resultSet.getString("vin"),
                            resultSet.getInt("year"),
                            resultSet.getString("make"),
                            resultSet.getString("model"),
                            resultSet.getString("vehicle_type"),
                            resultSet.getString("color"),
                            resultSet.getInt("odometer"),
                            resultSet.getDouble("price"),
                            resultSet.getBoolean("sold")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateVehicle(Vehicle vehicle) {
        try (   Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "UPDATE vehicles SET make=?, model=?, year=?, color=?, price=?, odometer=?, vehicle_type=? WHERE vin=?")) {

            statement.setString(1, vehicle.getMake());
            statement.setString(2, vehicle.getModel());
            statement.setInt(3, vehicle.getYear());
            statement.setString(4, vehicle.getColor());
            statement.setDouble(5, vehicle.getPrice());
            statement.setInt(6, vehicle.getOdometer());
            statement.setString(7, vehicle.getVehicleType());
            statement.setString(8, vehicle.getVin());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteVehicle(String vin) {
        try (   Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement("DELETE FROM vehicles WHERE vin=?")) {
            statement.setString(1, vin);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // add sales contract to DB
    public List<SalesContract> getAllSalesContract(){
        ArrayList<SalesContract> salesContracts = new ArrayList<>();
        try (   Connection connection = dataSource.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM sales_contracts")) {

            while (resultSet.next()) {
                SalesContract salesContract = new SalesContract(
                        resultSet.getDate("sale_date").toLocalDate(),
                        resultSet.getString("buyer_name"),
                        resultSet.getString("email"),
                        resultSet.getString("vin"),
                        resultSet.getBoolean("isFinance")

                );
                salesContracts.add(salesContract);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return salesContracts;
    }
    public void addSalesContractDetails(SalesContract salesContract) {

        try (   Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "INSERT INTO sales_contracts (vin, buyer_name, sale_date,email,isFinance) VALUES (?,?,?,?,?)")) {

            statement.setString(1, "20JKLMNOPQRSTU10");
            statement.setString(2, salesContract.getCustomerName());
            statement.setDate(3, java.sql.Date.valueOf("2023-12-22"));
            statement.setString(4,salesContract.getEmail());
            statement.setBoolean(5,salesContract.isFinance());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<LeaseContract> getAllLeaseContract(){
        ArrayList<LeaseContract> leaseContracts = new ArrayList<>();
        try (   Connection connection = dataSource.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM lease_contracts")) {

            while (resultSet.next()) {
                LeaseContract leaseContract = new LeaseContract(
                        resultSet.getDate("sale_date").toLocalDate(),
                        resultSet.getString("buyer_name"),
                        resultSet.getString("email"),
                        resultSet.getString("vin")
                );
                leaseContracts.add(leaseContract);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return leaseContracts;
    }

    public void addLeaseContractDetails(LeaseContract leaseContract) {
        try (   Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "INSERT INTO lease_contracts (vin, buyer_name, sale_date,email) VALUES (?,?,?,?)")) {

            statement.setString(1,"3CDE3456789FGH10");
            statement.setString(2, leaseContract.getCustomerName());
            statement.setDate(3, java.sql.Date.valueOf("2023-12-22"));
            statement.setString(4, leaseContract.getEmail());


            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
