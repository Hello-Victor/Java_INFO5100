package Business;

import Business.Employee.Employee;
import Business.Employee.Person;
import Business.Enterprise.HospitalSystem;
import Business.Enterprise.InsuranceSystem;
import Business.Enterprise.NewsSystem;
import Business.Enterprise.RescueSystem;
import Business.Enterprise.ResidentSystem;
import Business.Enterprise.SupplySystem;
import Business.Organization.CarInsuranceOrganization;
import Business.Organization.ElectricityOrganization;
import Business.Organization.EmergencyMessageOrganization;
import Business.Organization.FoodOrganization;
import Business.Organization.HospitalOrganization;
import Business.Organization.HouseInsuranceOrganization;
import Business.Organization.Organization;
import Business.Organization.RadioOrganization;
import Business.Organization.RescueOrganization;
import Business.Organization.ResidentOrganization;
import Business.Organization.TVOrganization;
import Business.Organization.WaterOrganization;
import Business.Role.AdminRole;
import Business.Role.CarInsurerRole;
import Business.Role.DoctorRole;
import Business.Role.EachFoodRecord;
import Business.Role.ElectricityEngineerRole;
import Business.Role.FoodSupplierRole;
import Business.Role.HouseInsurerRole;
import Business.Role.OrganizationAdminRole;
import Business.Role.RescuerRole;
import Business.Role.ResidentRole;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import Business.Role.WaterEngineerRole;
import Business.UserAccount.UserAccount;
import Business.Utilities.FakeFactory;
import Business.WorkQueue.CarInsuranceRequest;
import Business.WorkQueue.ElectricityRequest;
import Business.WorkQueue.FoodRequest;
import Business.WorkQueue.HospitalRequest;
import Business.WorkQueue.HouseInsuranceRequest;
import Business.WorkQueue.NewsRequest;
import Business.WorkQueue.RescueRequest;
import Business.WorkQueue.WaterRequest;
import Business.WorkQueue.WorkRequest;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author rrheg
 */
public class ConfigureASystem {

    public static Ecosystem configure() {

        // Ecosystem
        Ecosystem ecosystem = Ecosystem.getInstance();
        FakeFactory.init();
        configureAdmin("sysadmin", "admin", ecosystem, SystemAdminRole.getInstance());

        // Enterprices
        InsuranceSystem insuranceSystem = new InsuranceSystem(ecosystem);
        HospitalSystem hospitalSystem = new HospitalSystem(ecosystem);
        RescueSystem rescueSystem = new RescueSystem(ecosystem);
        NewsSystem newsSystem = new NewsSystem(ecosystem);
        SupplySystem supplySystem = new SupplySystem(ecosystem);
        ResidentSystem residentSystem = new ResidentSystem(ecosystem);
        ecosystem.setInsuranceSystem(insuranceSystem);
        ecosystem.setHospitalSystem(hospitalSystem);
        ecosystem.setRescueSystem(rescueSystem);
        ecosystem.setNewsSystem(newsSystem);
        ecosystem.setSupplySystem(supplySystem);
        ecosystem.setResidentSystem(residentSystem);
        ecosystem.getOrganizationDirectory().getOrganizationList().add(insuranceSystem);
        ecosystem.getOrganizationDirectory().getOrganizationList().add(hospitalSystem);
        ecosystem.getOrganizationDirectory().getOrganizationList().add(rescueSystem);
        ecosystem.getOrganizationDirectory().getOrganizationList().add(newsSystem);
        ecosystem.getOrganizationDirectory().getOrganizationList().add(supplySystem);
        ecosystem.getOrganizationDirectory().getOrganizationList().add(residentSystem);
        configureAdmin("insurance.sys", "admin", insuranceSystem, AdminRole.getInstance());
        configureAdmin("hospital.sys", "admin", hospitalSystem, AdminRole.getInstance());
        configureAdmin("rescue.sys", "admin", rescueSystem, AdminRole.getInstance());
        configureAdmin("news.sys", "admin", newsSystem, AdminRole.getInstance());
        configureAdmin("supply.sys", "admin", supplySystem, AdminRole.getInstance());
        configureAdmin("resident.sys", "admin", residentSystem, AdminRole.getInstance());

        // Organizations
        CarInsuranceOrganization carInsuranceOrganization = new CarInsuranceOrganization(insuranceSystem);
        HouseInsuranceOrganization houseInsuranceOrganization = new HouseInsuranceOrganization(insuranceSystem);
        insuranceSystem.setCarInsuranceOrganization(carInsuranceOrganization);
        insuranceSystem.setHouseInsuranceOrganization(houseInsuranceOrganization);
        insuranceSystem.getOrganizationDirectory().getOrganizationList().add(carInsuranceOrganization);
        insuranceSystem.getOrganizationDirectory().getOrganizationList().add(houseInsuranceOrganization);
        configureAdmin("car.org", "admin", carInsuranceOrganization, OrganizationAdminRole.getInstance());
        configureAdmin("house.org", "admin", houseInsuranceOrganization, OrganizationAdminRole.getInstance());

        HospitalOrganization hospitalOrganization = new HospitalOrganization(hospitalSystem);
        hospitalSystem.setHospitalOrganization(hospitalOrganization);
        hospitalSystem.getOrganizationDirectory().getOrganizationList().add(hospitalOrganization);
        configureAdmin("hospital.org", "admin", hospitalOrganization, OrganizationAdminRole.getInstance());

        RescueOrganization rescueOrganization = new RescueOrganization(rescueSystem);
        rescueSystem.setRescueOrganization(rescueOrganization);
        rescueSystem.getOrganizationDirectory().getOrganizationList().add(rescueOrganization);
        configureAdmin("rescue.org", "admin", rescueOrganization, OrganizationAdminRole.getInstance());

        RadioOrganization radioOrganization = new RadioOrganization(newsSystem);
        EmergencyMessageOrganization emergencyMessageOrganization = new EmergencyMessageOrganization(newsSystem);
        TVOrganization tvOrganization = new TVOrganization(newsSystem);
        newsSystem.setEmergencyMessageOrganization(emergencyMessageOrganization);
        newsSystem.setRadioOrganization(radioOrganization);
        newsSystem.setTvOrganization(tvOrganization);
        newsSystem.getOrganizationDirectory().getOrganizationList().add(tvOrganization);
        newsSystem.getOrganizationDirectory().getOrganizationList().add(emergencyMessageOrganization);
        newsSystem.getOrganizationDirectory().getOrganizationList().add(radioOrganization);
        configureAdmin("tv.org", "admin", tvOrganization, OrganizationAdminRole.getInstance());
        configureAdmin("radio.org", "admin", radioOrganization, OrganizationAdminRole.getInstance());
        configureAdmin("message.org", "admin", emergencyMessageOrganization, OrganizationAdminRole.getInstance());

        ElectricityOrganization electricityOrganization = new ElectricityOrganization(supplySystem);
        WaterOrganization waterOrganization = new WaterOrganization(supplySystem);
        FoodOrganization foodOrganization = new FoodOrganization(supplySystem);
        supplySystem.setElectricityOrganization(electricityOrganization);
        supplySystem.setFoodOrganization(foodOrganization);
        supplySystem.setWaterOrganization(waterOrganization);
        supplySystem.getOrganizationDirectory().getOrganizationList().add(electricityOrganization);
        supplySystem.getOrganizationDirectory().getOrganizationList().add(waterOrganization);
        supplySystem.getOrganizationDirectory().getOrganizationList().add(foodOrganization);
        configureAdmin("power.org", "admin", electricityOrganization, OrganizationAdminRole.getInstance());
        configureAdmin("water.org", "admin", waterOrganization, OrganizationAdminRole.getInstance());
        configureAdmin("food.org", "admin", foodOrganization, OrganizationAdminRole.getInstance());

        ResidentOrganization residentOrganization = new ResidentOrganization(rescueSystem);
        residentSystem.setResidentOrganization(residentOrganization);
        residentSystem.getOrganizationDirectory().getOrganizationList().add(residentOrganization);
        configureAdmin("resident.org", "admin", residentOrganization, OrganizationAdminRole.getInstance());

        // Employees
        ArrayList<Employee> carInsurers = new ArrayList();
        ArrayList<Employee> houseInsurers = new ArrayList();
        ArrayList<Employee> doctors = new ArrayList();
        ArrayList<Employee> rescuers = new ArrayList();
        ArrayList<Employee> electricityEngineers = new ArrayList();
        ArrayList<Employee> waterEngineers = new ArrayList();
        ArrayList<Employee> foodSuppliers = new ArrayList();
        int ncarInsurers = FakeFactory.varyCount(16);
        int nhouseInsurers = FakeFactory.varyCount(16);
        int ndoctors = FakeFactory.varyCount(16);
        int nrescuers = FakeFactory.varyCount(16);
        int nelectricityEngineers = FakeFactory.varyCount(16);
        int nwaterEngineers = FakeFactory.varyCount(16);
        int nfoodSuppliers = FakeFactory.varyCount(16);

        for (int i = 0; i < ncarInsurers; i++) {
            carInsurers.add(getEmployee(carInsuranceOrganization, CarInsurerRole.getInstance()));
        }
        System.out.println("car" + String.valueOf(carInsurers.get(1).getId()));
        for (int i = 0; i < ncarInsurers; i++) {
            houseInsurers.add(getEmployee(houseInsuranceOrganization, HouseInsurerRole.getInstance()));
        }
        System.out.println("house" + String.valueOf(houseInsurers.get(1).getId()));
        for (int i = 0; i < ndoctors; i++) {
            doctors.add(getEmployee(hospitalOrganization, DoctorRole.getInstance()));
        }
        System.out.println("doctor" + String.valueOf(doctors.get(1).getId()));
        for (int i = 0; i < nrescuers; i++) {
            rescuers.add(getEmployee(rescueOrganization, RescuerRole.getInstance()));
        }
        System.out.println("rescue" + String.valueOf(rescuers.get(1).getId()));
        for (int i = 0; i < nelectricityEngineers; i++) {
            electricityEngineers.add(getEmployee(electricityOrganization, ElectricityEngineerRole.getInstance()));
        }
        System.out.println("power" + String.valueOf(electricityEngineers.get(1).getId()));
        for (int i = 0; i < nwaterEngineers; i++) {
            waterEngineers.add(getEmployee(waterOrganization, WaterEngineerRole.getInstance()));
        }
        System.out.println("water" + String.valueOf(waterEngineers.get(1).getId()));
        for (int i = 0; i < nfoodSuppliers; i++) {
            foodSuppliers.add(getEmployee(foodOrganization, FoodSupplierRole.getInstance()));
        }
        System.out.println("food" + String.valueOf(foodSuppliers.get(1).getId()));

        ArrayList<Employee> residents = new ArrayList();
        int nresidents = FakeFactory.varyCount(80);

        for (int i = 0; i < nresidents; i++) {
            residents.add(getEmployee(residentOrganization, ResidentRole.getInstance()));
        }
        System.out.println("resident" + String.valueOf(residents.get(1).getId()));
        String[] carplans = {"Triple A full coverage", "Allstate premium", "USAA cheap full coverage"};
        String[] houseplans = {"Nationwide full coverage", "US Home basic coverage", "Progressive liability"};
        for (Employee e : residents) {
            e.setCarPlan(carplans[FakeFactory.getRandom().nextInt(3)]);
            e.setHousePlan(houseplans[FakeFactory.getRandom().nextInt(3)]);
        }

        // Requests
        double assignRatio = 0.7;
        double cancelRatio = 2.;
        double completeRatio = 2.;
        double sendMsgRatio = 0.3;
        int nBaseRquests = 8;
        int nBaseEmergencies = 8;
        int baseLoss = 1000;
        double eventSpan = 3;
        double eventInterval = 15;
        double assignSpan = 0.02;
        double completeSpan = 0.6;

        int nEmergencies;
        int nRequests;
        int selectedIdx;

        nEmergencies = FakeFactory.varyCount(nBaseEmergencies);
        Date date = FakeFactory.getRandomDate(new Date(), -(nEmergencies + 1) * (eventInterval + eventSpan));
        Date requestDate;
        Date assignDate;
        Date completeDate;
        for (int e = 0; e < nEmergencies; e++) {
            NewsRequest newsRequest = new NewsRequest();
            String messageString = FakeFactory.getFaker().harryPotter().quote();
            newsRequest.setMessage(messageString);
            newsRequest.setStatus(WorkRequest.Status.Completed);
            newsSystem.getWorkQueue().getWorkRequestList().add(newsRequest);
            date = FakeFactory.getRandomDate(date, FakeFactory.varyDist((double) eventInterval));
            newsRequest.setRequestDate(date);
            if (FakeFactory.getRandom().nextDouble() < sendMsgRatio) {
                tvOrganization.addNewMessage(newsRequest);
            }
            if (FakeFactory.getRandom().nextDouble() < sendMsgRatio) {
                emergencyMessageOrganization.addNewMessage(newsRequest);
            }
            if (FakeFactory.getRandom().nextDouble() < sendMsgRatio) {
                radioOrganization.addNewMessage(newsRequest);
            }
            if (FakeFactory.getRandom().nextDouble() < sendMsgRatio) {
                residentOrganization.addNewMessage(newsRequest);
            }
            nRequests = FakeFactory.varyCount(nBaseRquests);
            requestDate = date;
            for (int i = 0; i < nRequests; i++) {
                CarInsuranceRequest request = new CarInsuranceRequest();
                request.setEvent(newsRequest);
                requestDate = FakeFactory.getRandomDate(requestDate, FakeFactory.varyDist(eventSpan / (double) (nRequests + 1)));
                request.setRequestDate(requestDate);
                assignDate = FakeFactory.getRandomDate(requestDate, FakeFactory.varyDist(assignSpan));
                completeDate = FakeFactory.getRandomDate(assignDate, FakeFactory.varyDist(completeSpan));
                request.setMessage(FakeFactory.getFaker().harryPotter().quote());
                selectedIdx = FakeFactory.getRandom().nextInt(nresidents);
                request.setSender(residents.get(selectedIdx).getUserAccount());
                request.setReceiver(carInsuranceOrganization);
                request.setLocation(FakeFactory.getRandomaddress());
                if (FakeFactory.getRandom().nextDouble() < assignRatio) {
                    selectedIdx = FakeFactory.getRandom().nextInt(ncarInsurers);
                    request.setAssignee(carInsurers.get(selectedIdx).getUserAccount());
                    request.setStatus(WorkRequest.Status.Accepted);
                    request.setAssignDate(assignDate);
                    if (FakeFactory.getRandom().nextDouble() < completeRatio) {
                        request.done();
                        request.setStatus(WorkRequest.Status.Completed);
                        request.setResolveDate(completeDate);
                        request.setFeedback(FakeFactory.getRandomfeedback());
                        request.setLoss(FakeFactory.varyCount(baseLoss));
                    }
                } else if (FakeFactory.getRandom().nextDouble() < cancelRatio) {
                    request.cancel();
                    request.setAssignDate(assignDate);
                }
            }

            nRequests = FakeFactory.varyCount(nBaseRquests);
            requestDate = date;
            for (int i = 0; i < nRequests; i++) {
                HouseInsuranceRequest request = new HouseInsuranceRequest();
                request.setEvent(newsRequest);
                requestDate = FakeFactory.getRandomDate(requestDate, FakeFactory.varyDist(eventSpan / (double) (nRequests + 1)));
                request.setRequestDate(requestDate);
                assignDate = FakeFactory.getRandomDate(requestDate, FakeFactory.varyDist(assignSpan));
                completeDate = FakeFactory.getRandomDate(assignDate, FakeFactory.varyDist(completeSpan));
                request.setMessage(FakeFactory.getFaker().harryPotter().quote());
                selectedIdx = FakeFactory.getRandom().nextInt(nresidents);
                request.setSender(residents.get(selectedIdx).getUserAccount());
                request.setReceiver(houseInsuranceOrganization);
                request.setLocation(FakeFactory.getRandomaddress());
                if (FakeFactory.getRandom().nextDouble() < assignRatio) {
                    selectedIdx = FakeFactory.getRandom().nextInt(nhouseInsurers);
                    request.setAssignee(houseInsurers.get(selectedIdx).getUserAccount());
                    request.setStatus(WorkRequest.Status.Accepted);
                    request.setAssignDate(assignDate);
                    if (FakeFactory.getRandom().nextDouble() < completeRatio) {
                        request.done();
                        request.setResolveDate(completeDate);
                        request.setFeedback(FakeFactory.getRandomfeedback());
                        request.setLoss(FakeFactory.varyCount(baseLoss));
                    }
                } else if (FakeFactory.getRandom().nextDouble() < cancelRatio) {
                    request.cancel();
                    request.setAssignDate(assignDate);
                }
            }

            nRequests = FakeFactory.varyCount(nBaseRquests);
            requestDate = date;
            for (int i = 0; i < nRequests; i++) {
                HospitalRequest request = new HospitalRequest();
                request.setEvent(newsRequest);
                requestDate = FakeFactory.getRandomDate(requestDate, FakeFactory.varyDist(eventSpan / (double) (nRequests + 1)));
                request.setRequestDate(requestDate);
                assignDate = FakeFactory.getRandomDate(requestDate, FakeFactory.varyDist(assignSpan));
                completeDate = FakeFactory.getRandomDate(assignDate, FakeFactory.varyDist(completeSpan));
                request.setMessage(FakeFactory.getFaker().harryPotter().quote());
                selectedIdx = FakeFactory.getRandom().nextInt(nresidents);
                request.setSender(residents.get(selectedIdx).getUserAccount());
                request.setReceiver(hospitalOrganization);
                request.setLocation(FakeFactory.getRandomaddress());
                if (FakeFactory.getRandom().nextDouble() < assignRatio) {
                    selectedIdx = FakeFactory.getRandom().nextInt(ndoctors);
                    request.setAssignee(doctors.get(selectedIdx).getUserAccount());
                    request.setStatus(WorkRequest.Status.Accepted);
                    request.setAssignDate(assignDate);
                    if (FakeFactory.getRandom().nextDouble() < completeRatio) {
                        request.done();
                        request.setResolveDate(completeDate);
                        request.setFeedback(FakeFactory.getRandomfeedback());
                    }
                } else if (FakeFactory.getRandom().nextDouble() < cancelRatio) {
                    request.cancel();
                    request.setAssignDate(assignDate);
                }
            }

            nRequests = FakeFactory.varyCount(nBaseRquests);
            requestDate = date;
            for (int i = 0; i < nRequests; i++) {
                RescueRequest request = new RescueRequest();
                request.setEvent(newsRequest);
                requestDate = FakeFactory.getRandomDate(requestDate, FakeFactory.varyDist(eventSpan / (double) (nRequests + 1)));
                request.setRequestDate(requestDate);
                assignDate = FakeFactory.getRandomDate(requestDate, FakeFactory.varyDist(assignSpan));
                completeDate = FakeFactory.getRandomDate(assignDate, FakeFactory.varyDist(completeSpan));
                request.setMessage(FakeFactory.getFaker().harryPotter().quote());
                selectedIdx = FakeFactory.getRandom().nextInt(nresidents);
                request.setSender(residents.get(selectedIdx).getUserAccount());
                request.setReceiver(rescueOrganization);
                request.setLocation(FakeFactory.getRandomaddress());
                if (FakeFactory.getRandom().nextDouble() < assignRatio) {
                    selectedIdx = FakeFactory.getRandom().nextInt(nrescuers);
                    request.setAssignee(rescuers.get(selectedIdx).getUserAccount());
                    request.setStatus(WorkRequest.Status.Accepted);
                    request.setAssignDate(assignDate);
                    if (FakeFactory.getRandom().nextDouble() < completeRatio) {
                        request.done();
                        request.setResolveDate(completeDate);
                        request.setFeedback(FakeFactory.getRandomfeedback());
                    }
                } else if (FakeFactory.getRandom().nextDouble() < cancelRatio) {
                    request.cancel();
                    request.setAssignDate(assignDate);
                }
            }

            nRequests = FakeFactory.varyCount(nBaseRquests);
            requestDate = date;
            for (int i = 0; i < nRequests; i++) {
                ElectricityRequest request = new ElectricityRequest();
                request.setEvent(newsRequest);
                requestDate = FakeFactory.getRandomDate(requestDate, FakeFactory.varyDist(eventSpan / (double) (nRequests + 1)));
                request.setRequestDate(requestDate);
                assignDate = FakeFactory.getRandomDate(requestDate, FakeFactory.varyDist(assignSpan));
                completeDate = FakeFactory.getRandomDate(assignDate, FakeFactory.varyDist(completeSpan));
                request.setMessage(FakeFactory.getFaker().harryPotter().quote());
                selectedIdx = FakeFactory.getRandom().nextInt(nresidents);
                request.setSender(residents.get(selectedIdx).getUserAccount());
                request.setReceiver(electricityOrganization);
                request.setLocation(FakeFactory.getRandomaddress());
                if (FakeFactory.getRandom().nextDouble() < assignRatio) {
                    selectedIdx = FakeFactory.getRandom().nextInt(nelectricityEngineers);
                    request.setAssignee(electricityEngineers.get(selectedIdx).getUserAccount());
                    request.setStatus(WorkRequest.Status.Accepted);
                    request.setAssignDate(assignDate);
                    if (FakeFactory.getRandom().nextDouble() < completeRatio) {
                        request.done();
                        request.setResolveDate(completeDate);
                        request.setFeedback(FakeFactory.getRandomfeedback());
                        request.setDecision(FakeFactory.getRandom().nextGaussian() < 0.5 ? "Power On" : "Power Off");
                    }
                } else if (FakeFactory.getRandom().nextDouble() < cancelRatio) {
                    request.cancel();
                    request.setAssignDate(assignDate);
                }
            }

            nRequests = FakeFactory.varyCount(nBaseRquests);
            requestDate = date;
            for (int i = 0; i < nRequests; i++) {
                WaterRequest request = new WaterRequest();
                request.setEvent(newsRequest);
                requestDate = FakeFactory.getRandomDate(requestDate, FakeFactory.varyDist(eventSpan / (double) (nRequests + 1)));
                request.setRequestDate(requestDate);
                assignDate = FakeFactory.getRandomDate(requestDate, FakeFactory.varyDist(assignSpan));
                completeDate = FakeFactory.getRandomDate(assignDate, FakeFactory.varyDist(completeSpan));
                request.setMessage(FakeFactory.getFaker().harryPotter().quote());
                selectedIdx = FakeFactory.getRandom().nextInt(nresidents);
                request.setSender(residents.get(selectedIdx).getUserAccount());
                request.setReceiver(waterOrganization);
                request.setLocation(FakeFactory.getRandomaddress());
                if (FakeFactory.getRandom().nextDouble() < assignRatio) {
                    selectedIdx = FakeFactory.getRandom().nextInt(nwaterEngineers);
                    request.setAssignee(waterEngineers.get(selectedIdx).getUserAccount());
                    request.setStatus(WorkRequest.Status.Accepted);
                    request.setAssignDate(assignDate);
                    if (FakeFactory.getRandom().nextDouble() < completeRatio) {
                        request.done();
                        request.setResolveDate(completeDate);
                        request.setFeedback(FakeFactory.getRandomfeedback());
                        request.setDecision(FakeFactory.getRandom().nextGaussian() < 0.5 ? "Water On" : "Water Off");
                    }
                } else if (FakeFactory.getRandom().nextDouble() < cancelRatio) {
                    request.cancel();
                    request.setAssignDate(assignDate);
                }
            }

        }
        requestDate = date;
        for (int i = 0; i < nfoodSuppliers / 2; i++) {
            FoodRequest request = new FoodRequest();
            requestDate = FakeFactory.getRandomDate(requestDate, FakeFactory.varyDist(eventSpan / (double) (nfoodSuppliers / 2 + 1)));
            request.setRequestDate(requestDate);
            assignDate = FakeFactory.getRandomDate(requestDate, FakeFactory.varyDist(assignSpan));
            completeDate = FakeFactory.getRandomDate(assignDate, FakeFactory.varyDist(completeSpan));
            request.setMessage(FakeFactory.getFaker().harryPotter().quote());
            selectedIdx = FakeFactory.getRandom().nextInt(nresidents);
            request.setSender(residents.get(selectedIdx).getUserAccount());
            request.setReceiver(foodOrganization);
            request.setLocation(FakeFactory.getRandomaddress());
            selectedIdx = i;
            request.setAssignee(foodSuppliers.get(selectedIdx).getUserAccount());
            request.setStatus(WorkRequest.Status.Accepted);
            request.setAssignDate(assignDate);
            request.setFoodRemain(FakeFactory.varyCount(150));
            for (int j = 0; j < 8; j++) {
                EachFoodRecord efr = new EachFoodRecord();
                selectedIdx = FakeFactory.getRandom().nextInt(nresidents);
                efr.setUserName(residents.get(selectedIdx).getName());
                efr.setNumber(FakeFactory.varyCount(3));
                request.getFoodRecord().add(efr);
            }
        }
        return ecosystem;
    }

    static void configureAdmin(String UserName, String Password, Organization organization, Role role) {
        Employee employee = organization.getEmployeeDirectory().createEmployee(UserName);
        UserAccount userAccount = Ecosystem.getInstance().getUserAccountDirectory().createUserAccount(UserName, Password, employee);
        Person person = new Person();
        person.setFirstname(UserName);
        organization.setAdminEmployee(employee);
        configureEmployee(employee, person, userAccount, organization, role);
    }

    static Employee getEmployee(Organization organization, Role role) {
        Person person = FakeFactory.getRandomPerson();
        Employee employee = organization.getEmployeeDirectory().createEmployee(person.getName());
        UserAccount userAccount = Ecosystem.getInstance().getUserAccountDirectory().createUserAccount(String.valueOf(employee.getId()), "admin", employee);
        configureEmployee(employee, person, userAccount, organization, role);
        return employee;
    }

    static void configureEmployee(Employee employee, Person person, UserAccount userAccount, Organization organization, Role role) {
        employee.setUserAccount(userAccount);
        employee.setOrganization(organization);
        employee.setPerson(person);
        employee.setRole(role);
    }

}
