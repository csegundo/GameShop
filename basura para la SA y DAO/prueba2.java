SA PROVIDER
public Integer createProvider(TProvider tp);
public Boolean deleteProvider(TProvider tp);
public Boolean updateProvider(TProvider tp);
public TProvider readProvider(TProvider tp);
public List<TProvider> readAllProviders();

SA EMPLOYEE
public Integer createEmployee(TEmployee te);
public Boolean deleteEmployee(TEmployee te);
public Boolean updateEmployee(TEmployee te);
public TEmployee readEmployee(TEmployee te);
public List<TEmployee> readAllEmployees();


SA PRODUCT
public Integer createProduct(TProduct tpr);
public Boolean deleteProduct(TProduct tpr);
public Boolean updateProduct(TProduct tpr);
public TProduct readProduct(TProduct tpr);
public List<TProduct> readAllProducts();

SA PLATFORM
public Integer createPlatform(TPlatform tpl);
public Boolean deletePlatform(TPlatform tpl);
public Boolean updatePlatform(TPlatform tpl);
public TPlatform readPlatform(TPlatform tpl);
public List<TPlatform> readAllPlatforms();

SA TICKET
public Integer createTicket(TTicket tt);
public Boolean deleteTicket(TTicket tt);
public Boolean updateTicket(TTicket tt);
public TTicket readTicket(TTicket tt);
public List<TTicket> readAllTickets();