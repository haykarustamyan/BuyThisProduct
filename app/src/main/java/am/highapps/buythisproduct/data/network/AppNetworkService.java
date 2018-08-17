package am.highapps.buythisproduct.data.network;

import am.highapps.buythisproduct.data.database.entity.Product;
import java.util.HashMap;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface AppNetworkService {

  @GET("cars/{userKey}.json")
  Call<HashMap<String, Product>> getCarList(
      @Path("userKey") String userKey);

  @PUT("/cars/{userKey}/{carKey}.json")
  Call<Product> saveCar(
      // title configured as identifier for tasks
      @Path("userKey") String userKey,
      @Path("carKey") String carKey,
      @Body Product car);

  @PATCH("/cars/{userKey}/{carKey}.json")
  Call<Product> updateCar(
      @Path("userKey") String userKey,
      @Path("carKey") String carKey,
      @Body Product car);


  @DELETE("/cars/{userKey}/{carKey}.json")
  Call<Product> deleteCar(
      @Path("userKey") String userKey,
      @Path("carKey") String carKey);


  @PUT("/oils/{carKey}/{oilKey}.json")
  Call<Product> saveOil(
      // title configured as identifier for tasks
      @Path("carKey") String carKey,
      @Path("oilKey") String oilKey,
      @Body Product oil);


  @GET("oils/{carKey}.json")
  Call<HashMap<String, Product>> getCarOils(
      @Path("carKey") String userKey);

  @PATCH("/oils/{carKey}/{oilKey}.json")
  Call<Product> updateOil(
      @Path("carKey") String carKey,
      @Path("oilKey") String oilKey,
      @Body Product oil);

  @DELETE("/oils/{carKey}.json")
  Call<Product> deleteOils(
      @Path("carKey") String carKey);
}
