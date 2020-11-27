package com.pepr.market.persistence.mapper;

import com.pepr.market.domain.Purchase;
import com.pepr.market.domain.PurchaseItem;
import org.mapstruct.InheritInverseConfiguration;
import com.pepr.market.persistence.entity.ComprasProducto;
import org.mapstruct.*;

@Mapper (componentModel = "spring", uses = {ProductMapper.class})
public interface PurchaseItemMapper {
 @Mappings ({
    @Mapping(source = "id.idProducto", target = "productId" ),
    @Mapping(source = "cantidad", target = "quantity" ),
    @Mapping(source = "estado", target = "active" ),
 })
    PurchaseItem toPurchaseItem(ComprasProducto producto);
@InheritInverseConfiguration
    @Mappings({
        @Mapping(target= "compra", ignore = true),
        @Mapping(target= "producto",ignore = true),
        @Mapping(target= "id.idCompra", ignore= true),
})
 ComprasProducto toComprasProducto(PurchaseItem item );
}
