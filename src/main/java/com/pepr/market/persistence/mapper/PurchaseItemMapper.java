package com.pepr.market.persistence.mapper;

import com.pepr.market.domain.Purchase;
import com.pepr.market.domain.PurchaseItem;
import com.pepr.market.persistence.entity.ComprasProducto;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper (componentModel = "Spring", uses = {ProductMapper.class})
public interface PurchaseItemMapper {
 @Mappings ({
    @Mapping(source = "id.idProducto", target = "productId" ),
    @Mapping(source = "cantidad", target = "quantity" ),
    @Mapping(source = "estado", target = "active" ),
 })
    PurchaseItem toPurchaseItem(ComprasProducto producto);
@InheritConfiguration
@Mappings({
        @Mapping(target= "compra", ignore = true),
        @Mapping(target= "producto",ignore = true),
        @Mapping(target= "id.idCompra", ignore= true),
})
 ComprasProducto toComprasProducto(PurchaseItem item );
}
