package com.android.catchtable.presentation.vote.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.catchtable.presentation.common.component.CatchTableAI
import com.android.catchtable.presentation.common.component.CatchTableSubwayBadge
import com.android.catchtable.presentation.common.theme.CatchTableTheme
import com.android.catchtable.presentation.vote.model.DummyVoteStores.dummyVoteStore
import com.android.catchtable.presentation.vote.model.VoteMenuUiModel
import com.android.catchtable.presentation.vote.model.VoteStoreModel
import com.android.catchtable.presentation.vote.model.VoteStoreUiModel
import com.android.catchtable.presentation.vote.model.VoteTagType

//고민! 이걸 component로 부르기엔 좀 그렇다. 네이밍을 screen으로 바꿔야할지 말지
@Composable
fun VoteInfo(
    store: VoteStoreModel,
    isSelected: Boolean,
    modifier: Modifier = Modifier,
    backgroundColor: Color,
    strokeColor: Color
){
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(backgroundColor)
            .padding(top = 12.dp, bottom = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ){
        Column(
            modifier = Modifier.padding(horizontal = 12.dp),
            verticalArrangement = Arrangement.spacedBy(48.dp)
        ){
            VoteCardStore(
                store = VoteStoreUiModel(
                    id = store.storeId,
                    thumbnailUrl = store.imageUrls,
                    name = store.name,
                    rating = store.rating.toString(),
                    reviewCount = store.reviewCount
                ),
                onCheckClick = {


                },
                isSelected = isSelected,
            )
            VoteTag(
                type = VoteTagType.RESERVED,
                onClick = {
                    //예약하기로 넘어가기
                }
            )
        }
        VoteInfoDivider(strokeColor)

        Column(
            modifier = Modifier.padding(horizontal = 12.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ){
            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ){
                store.station.lines.forEach { line ->
                    CatchTableSubwayBadge(line)
                }
            }
            Text(
                text = "${store.station.name}에서 ${store.station.distanceMeters}m",
                style = CatchTableTheme.typography.bodyB12,
                color = CatchTableTheme.colors.gray900
            )
        }

        VoteInfoDivider(strokeColor)

        VoteInfoSection(
            title = {
                CatchTableAI(
                    iconSize = 12.dp,
                    title = " 요약",
                    style = CatchTableTheme.typography.h3B14
                )
            },
            content = { VoteInfoSectionContent(text = store.aiSummary?.title.orEmpty()) }
        )

        VoteInfoDivider(strokeColor)

        VoteInfoSection(
            title = { VoteInfoSectionTitle(text = "가격대") },
            content = { VoteInfoSectionContent(text = store.priceRange) }
        )

        VoteInfoDivider(strokeColor)

        VoteInfoSection(
            title = { VoteInfoSectionTitle(text = "대표 메뉴") },
            content = {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        store.representativeMenu.getOrNull(0)?.let { menu ->
                            VoteCardMenu(
                                menu = VoteMenuUiModel(
                                    menuId = menu.menuId,
                                    storeId = store.storeId,
                                    menuImageUrl = menu.imageUrl,
                                    name = menu.name,
                                    price = menu.price.toString(),
                                    isPriceFrom = menu.isPriceFrom
                                ),
                                modifier = Modifier.weight(1f)
                            )
                        }
                        store.representativeMenu.getOrNull(1)?.let { menu ->
                            VoteCardMenu(
                                menu = VoteMenuUiModel(
                                    menuId = menu.menuId,
                                    storeId = store.storeId,
                                    menuImageUrl = menu.imageUrl,
                                    name = menu.name,
                                    price = menu.price.toString(),
                                    isPriceFrom = menu.isPriceFrom
                                ),
                                modifier = Modifier.weight(1f)
                            )
                        }
                    }
                    VoteTag(
                        type = VoteTagType.VIEW_ALL,
                        onClick = {
                            //메뉴보러가기
                        }
                    )
                }
            },
            spaceBy = 8.dp
        )
        VoteInfoDivider(strokeColor)

        VoteInfoSection(
            title = { VoteInfoSectionTitle(text = "주류 및 콜키지") },
            content = {
                VoteInfoSectionContent(
                    text = store.amenities.content,
                    minLines = 3
                )
            }
        )

        Spacer(modifier = Modifier.height(0.dp))

    }
}

@Composable
private fun VoteInfoDivider(
    color: Color
) {
    HorizontalDivider(
        color = color,
        thickness = 1.dp
    )
}

@Preview(showBackground = true, heightDp = 1500)
@Composable
private fun VoteInfoPreview(){
    CatchTableTheme {
        VoteInfo(
            store = dummyVoteStore,
            isSelected = true,
            modifier = Modifier.width(300.dp),
            backgroundColor = CatchTableTheme.colors.white,
            strokeColor = CatchTableTheme.colors.gray200
        )
    }
}