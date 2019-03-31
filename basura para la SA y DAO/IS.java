DAO PROVIDER
public Integer createProvider(TProvider tp);
public Boolean deleteProvider(TProvider tp);
public Boolean updateProvider(TProvider tp);
public TProvider readProvider(TProvider tp);
public List<TProvider> readAllProviders();
public Integer existsProviderByNIF(TProvider tp);

DAO EMPLOYEE
public Integer createEmployee(TEmployee te);
public Boolean deleteEmployee(TEmployee te);
public Boolean updateEmployee(TEmployee te);
public TEmployee readEmployee(TEmployee te);
public List<TEmployee> readAllEmployees();
public Integer existsEmployeeByNIF(TEmployee te);


DAO PRODUCT
public Integer createProduct(TProduct tpr);
public Boolean deleteProduct(TProduct tpr);
public Boolean updateProduct(TProduct tpr);
public TProduct readProduct(TProduct tpr);
public List<TProduct> readAllProducts();
public Integer existsProductByName(TProduct tpr);

DAO PLATFORM
public Integer createPlatform(TPlatform tpl);
public Boolean deletePlatform(TPlatform tpl);
public Boolean updatePlatform(TPlatform tpl);
public TPlatform readPlatform(TPlatform tpl);
public List<TPlatform> readAllPlatforms();
public Integer existsPlatformByName(TPlatform tpl);

DAO TICKET
public Integer createTicket(TTicket tt);
public Boolean deleteTicket(TTicket tt);
public Boolean updateTicket(TTicket tt);
public TTicket readTicket(TTicket tt);
public List<TTicket> readAllTickets();
public Integer existsTicketByDate(TTicket tt);